# TableFunApp

An Android soundboard app for board game nights. Each player gets their own block, which is a single tap, that plays a short clip, while a double tap starts a longer sound clip.

Built in Kotlin with Jetpack Compose.

## What it does

The main screen is a grid of cues: one per player plus one for the shop phase. Blocks show the name and, where set, the sound title. Audio lives locally on the device, so playback is instant and works without a network connection.

There is also a search screen backed by the YouTube Data API v3, used to find and identify sounds when setting up new themes.

## Architecture

MVVM with a repository layer:

```
Screen (Compose)    →  renders state, sends events up
ViewModel           →  owns UI state
Repository          →  fetches data, maps DTO to domain model
Retrofit interface  →  describes the HTTP call
YouTube Data API    →  returns JSON
```

Each layer only knows the one below it.

### Three repositories, three data sources

The project deliberately has three repositories backed by entirely different sources:

| Repository | Source | Asynchronous? |
|---|---|---|
| `YouTubeRepository` | REST over the network (Retrofit + Gson) | Yes, callback-based |
| `CueRepository` | Hardcoded in-memory list | No |
| `SoundRepository` | Audio files in `res/raw` via MediaPlayer | No |

From a ViewModel's point of view they are identical. That is the whole point of the layer: **a repository abstracts a data source. Not necessarily a network.**



`YouTubeRepository` is the boundary: below it there are only DTOs, above it only `Song`. The translation happens in `SongMapper.toSong()`, which also handles fallbacks — thumbnails fall back from `high` to `medium` to `default`, and results without a `videoId` are filtered out.

If YouTube changes their JSON, the DTOs and the mapper change. The rest of the app is untouched.

### Error handling

With Retrofit's callback style, network calls do not throw:

- `onFailure` the request never reached the server (no connection, timeout, DNS)
- `onResponse` with `!isSuccessful`: the server responded but rejected the call. A 403 lands here, not in `onFailure`

Both are surfaced as an error message that the ViewModel exposes and the screen renders.

### State

State lives in the ViewModel, not in the repository. This departs from a fair amount of teaching material that puts `mutableStateOf` in the data layer. Two reasons:

- Two screens sharing a repository would also share `isLoading` and `errorMessage`
- `mutableStateOf` is a Compose type, putting it in the data layer means the layer can't be reused without Compose

## Testing

`SongMapper` was extracted into a standalone extension function because the mapping, while it sat inside an anonymous callback, could not be tested without making a real network call.

Unit tests in `src/test` cover the mapper: that items without a `videoId` are dropped, and that the thumbnail fallback picks correctly. Plain JVM, no emulator.



Kotlin · Jetpack Compose · Material 3 · Navigation Compose · ViewModel · Retrofit 3 · Gson · MediaPlayer · JUnit

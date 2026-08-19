# TableFunApp

An Android soundboard app for board game nights. Each player gets their own block — a single tap plays a short clip, a double tap starts a longer song.

Built in Kotlin with Jetpack Compose.

## What it does

The main screen is a grid of cues: one per player plus one for the shop phase. Blocks show the name and, where set, the song title. Audio lives locally on the device, so playback is instant and works without a network connection.

There is also a search screen backed by the YouTube Data API v3, used to find and identify songs when setting up new themes.

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

From a ViewModel's point of view they are identical. That is the whole point of the layer: **a repository abstracts a data source — not necessarily a network.**

### DTO vs. domain model

The YouTube response is deeply nested (`items[].snippet.thumbnails.high.url`) and every field is optional. The DTO classes mirror that structure exactly and are nullable throughout, because Gson bypasses Kotlin's null safety.

`YouTubeRepository` is the boundary: below it there are only DTOs, above it only `Song`. The translation happens in `SongMapper.toSong()`, which also handles fallbacks — thumbnails fall back from `high` to `medium` to `default`, and results without a `videoId` are filtered out.

If YouTube changes their JSON, the DTOs and the mapper change. The rest of the app is untouched.

### Error handling

With Retrofit's callback style, network calls do not throw:

- `onFailure` — the request never reached the server (no connection, timeout, DNS)
- `onResponse` with `!isSuccessful` — the server responded but rejected the call. A 403 lands here, not in `onFailure`

Both are surfaced as an error message that the ViewModel exposes and the screen renders.

### State

State lives in the ViewModel, not in the repository. This departs from a fair amount of teaching material that puts `mutableStateOf` in the data layer. Two reasons:

- Two screens sharing a repository would also share `isLoading` and `errorMessage`
- `mutableStateOf` is a Compose type — putting it in the data layer means the layer can't be reused without Compose

## Testing

`SongMapper` was extracted into a standalone extension function because the mapping, while it sat inside an anonymous callback, could not be tested without making a real network call.

Unit tests in `src/test` cover the mapper: that items without a `videoId` are dropped, and that the thumbnail fallback picks correctly. Plain JVM, no emulator.

## Getting started

1. Clone the repo
2. Create an API key for the YouTube Data API v3 in the Google Cloud Console
3. Add it to `local.properties`:
   ```
   YOUTUBE_API_KEY=your_key
   ```
4. Put audio files in `app/src/main/res/raw/` (see below)
5. Build and run

### Audio files

Audio files are not included in the repo. Naming: `<cue>_short.ogg` and `<cue>_long.mp3` — lowercase letters, digits and underscores only, since filenames become constants in `R.raw`.

Short clips as OGG (better compression, no encoder padding at the start), long ones as MP3.

## Known limitations

- Files in `res/raw` are compiled into the APK, so adding songs requires a new build
- `onDoubleClick` introduces roughly 300 ms of latency on the short clip, since Compose waits to see whether a second tap follows
- The API key has no application restrictions — needs Android + SHA-1 before distribution
- Search results are not cached; each search costs 100 quota units out of 10,000 per day

## Stack

Kotlin · Jetpack Compose · Material 3 · Navigation Compose · ViewModel · Retrofit 3 · Gson · MediaPlayer · JUnit

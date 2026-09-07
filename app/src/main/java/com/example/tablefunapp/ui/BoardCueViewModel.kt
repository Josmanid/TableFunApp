package com.example.tablefunapp.ui

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.NO_SOUND
import com.example.tablefunapp.models.pickWeighted
import com.example.tablefunapp.repository.BoardRepository
import com.example.tablefunapp.repository.SoundRepository

class BoardCueViewModel(application: Application) : AndroidViewModel(application) {

    //Dependency
    private val boardRepository = BoardRepository()
    private val soundRepository = SoundRepository(application)


    //States to hold
    //which cue are playing?
    val playingLongCueId = mutableStateOf<Int?>(null)
    val playingShortCueId = mutableStateOf<Int?>(null)

    val playerCount = 5
    val cues = mutableStateOf<List<Cue>>(emptyList())

    fun loadBoard(boardId: Int) {
        val board = boardRepository.getBoards().find { it.id == boardId }
        cues.value = board?.cues ?: emptyList()
    }

    fun playShort(cue: Cue) {
        if (cue.shortSound == NO_SOUND) return
        if (playingShortCueId.value == cue.id) { //Guard clause when double tap for same long sound
            soundRepository.stopShort()
            playingShortCueId.value = null
            return
        }
        playingShortCueId.value = cue.id
        soundRepository.playShort(cue.shortSound) {
            playingShortCueId.value = null
        }
        // playingCueId.value = null is not possible here need call back
    }

    fun playNext() {
        val current = playingLongCueId.value
        val next = cues.value.indexOfFirst { it.id == current } // Returns -1 with start
        val nextSong = (next + 1) % playerCount
        playLong(cues.value[nextSong])
    }

    fun playBack() {
        val current = playingLongCueId.value
        val next = cues.value.indexOfFirst { it.id == current }
        val lastSong = (playerCount + (next - 1)) % playerCount
        playLong(cues.value[lastSong])
    }

    fun playLong(cue: Cue) {
        if (cue.longSounds.isEmpty()) return //Guard clause when empty
        if (playingLongCueId.value == cue.id) { //Guard clause when double tap for same long sound
            soundRepository.stopLong()
            playingLongCueId.value = null
            return
        }
        playingLongCueId.value = cue.id
        soundRepository.playLong(cue.longSounds.pickWeighted()) {
            playingLongCueId.value = null
        }
    }

    fun onStop() {
        soundRepository.stopLong()
        soundRepository.stopShort()
        playingLongCueId.value = null
        playingShortCueId.value = null
    }

    override fun onCleared() {
        super.onCleared()
        soundRepository.stopLong()
        soundRepository.stopShort()
    }

}
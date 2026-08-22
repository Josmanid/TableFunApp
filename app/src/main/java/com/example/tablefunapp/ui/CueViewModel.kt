package com.example.tablefunapp.ui

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.NO_SOUND
import com.example.tablefunapp.repository.CueRepository
import com.example.tablefunapp.repository.SoundRepository

class CueViewModel(application: Application) : AndroidViewModel(application) {

    //Dependency
    private val cueRepository = CueRepository()
    private val soundRepository = SoundRepository(application)

    //States to hold
    val cues = mutableStateOf<List<Cue>>(emptyList())

    init {
        cues.value = cueRepository.getCues()
    }

    fun playShort(cue: Cue) {
        if(cue.shortSound == NO_SOUND) return
        soundRepository.play(cue.shortSound)
    }

    fun playLong(cue: Cue) {
        if(cue.longSounds.isEmpty()) return
        soundRepository.play(cue.longSounds.random())
    }

    override fun onCleared() {
        super.onCleared()
        soundRepository.stop()
    }

}
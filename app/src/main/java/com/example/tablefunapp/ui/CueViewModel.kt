package com.example.tablefunapp.ui

import android.app.Application
import android.content.IntentSender
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.NO_SOUND
import com.example.tablefunapp.models.pickWeighted
import com.example.tablefunapp.repository.CueRepository
import com.example.tablefunapp.repository.SoundRepository

class CueViewModel(application: Application) : AndroidViewModel(application) {

    //Dependency
    private val cueRepository = CueRepository()
    private val soundRepository = SoundRepository(application)

    //States to hold
    //which cue are playing?
    val playingCueId = mutableStateOf<Int?>(null)
    val cues = mutableStateOf<List<Cue>>(emptyList())

    init {
        cues.value = cueRepository.getCues()
    }

    fun playShort(cue: Cue) {
        if(cue.shortSound == NO_SOUND) return
        playingCueId.value = cue.id
        soundRepository.play(cue.shortSound){
            playingCueId.value = null
        }
        // playingCueId.value = null is not possible here need call back

    }

    fun playLong(cue: Cue) {
        if(cue.longSounds.isEmpty()) return
        playingCueId.value = cue.id // TODO: can be problematic when implementing a big stop
        soundRepository.play(cue.longSounds.pickWeighted()){
            playingCueId.value = null
        }
    }

    override fun onCleared() {
        super.onCleared()
        soundRepository.stop()
    }

}
package com.example.tablefunapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.repository.CueRepository

class CueViewModel : ViewModel() {

    //Dependency
    private val repository = CueRepository()

    //States to hold
    val cues = mutableStateOf<List<Cue>>(emptyList())

    init {
        cues.value = repository.getCues()
    }

}
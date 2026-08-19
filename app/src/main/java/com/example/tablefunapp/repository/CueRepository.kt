package com.example.tablefunapp.repository

import com.example.tablefunapp.models.Cue
import java.util.Collections.list

class CueRepository {
    //making a list of private hardcodet properties
    private val cues = listOf(
        Cue(id = 1, name = "Jonas", shortSound = 0, longSound = 0, longTitle = ""),
        Cue(2, "Spiller 2", 0, 0, ""),
        Cue(3, "Spiller 3", 0, 0, ""),
        Cue(4, "Spiller 4", 0, 0, ""),
        Cue(5, "Shop", 0, 0, "")
    )
    //Promises to return a list of type Cue
    fun getCues(): List<Cue> {return cues}

}
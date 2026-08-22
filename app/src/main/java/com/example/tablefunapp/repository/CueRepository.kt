package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue

class CueRepository {
    //making a list of private hardcodet properties

    private val cues = listOf(
        Cue(id = 1, name = "den udøvende magt", shortSound = R.raw.kristian_short_the_darkness, longSound = R.raw.kristian_long_pepsiman, longTitle = " ", image = R.drawable.revenge),
        Cue(2, "Vakuu", R.raw.random_short_heheboi, R.raw.crone_long_moge, ""),
        Cue(3, "Håbet", R.raw.random_short_what, R.raw.lassen_long_svampebob, "", image = R.drawable.leende_ko_classic),
        Cue(4, "JohnzeManden", R.raw.johnz_short_hereisjohnny, R.raw.jonas_long_tubabrothers, ""),
        Cue(5, "Shop", R.raw.random_short_nice, R.raw.shop_long_elderscrolls, ""),
        Cue(6, "SideQuest", 0, R.raw.random_long_sidequest, "")
    )
    //Promises to return a list of type Cue
    fun getCues(): List<Cue> {return cues}

}
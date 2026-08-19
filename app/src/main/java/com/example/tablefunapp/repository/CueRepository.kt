package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue
import java.util.Collections.list

class CueRepository {
    //making a list of private hardcodet properties
    private val cues = listOf(
        Cue(id = 1, name = "Kristian", shortSound = R.raw.kristian_short_the_darkness, longSound = R.raw.kristian_long_pepsiman, longTitle = "Pepsiman"),
        Cue(2, "Cronbach", R.raw.random_short_heheboi, R.raw.crone_long_moge, "Moge time!!"),
        Cue(3, "Håbet", R.raw.random_short_what, R.raw.lassen_long_svampebob, ""),
        Cue(4, "Kaos Gutten", R.raw.random_short_youcandoit, R.raw.jonas_long_tubabrothers, ""),
        Cue(5, "Shop", R.raw.random_short_nice, R.raw.shop_long_elderscrolls, "")
    )
    //Promises to return a list of type Cue
    fun getCues(): List<Cue> {return cues}

}
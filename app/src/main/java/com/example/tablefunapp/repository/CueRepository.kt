package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue

class CueRepository {
    //making a list of private hardcodet properties

    private val cues = listOf(
        Cue(
            id = 1, name = "den udøvende magt", shortSound = R.raw.kristian_short_the_darkness,
            longSounds = listOf(
                R.raw.kristian_long_legendofsexy,
                R.raw.kristian_long_pepsiman,
                R.raw.crone_long_moge,
                R.raw.kristian_long_sheksophone
            ), longTitle = " ", image = R.drawable.revenge
        ),
        Cue(
            2,
            "Vakuu",
            R.raw.handsomelegend_short,
            listOf(
                R.raw.crone_long_moge,
                R.raw.crone_long_mitchirineko_march
                ),
            "",
            image = R.drawable.vakuu
        ),
        Cue(
            3,
            "Håbet",
            R.raw.wabuu_short,
            listOf(
                R.raw.lassen_long_svampebob,
                R.raw.lassen_long_mosan,
                R.raw.gutgunug_short
                ),
            "",
            image = R.drawable.leende_ko_classic
        ),
        Cue(
            4,
            "JohnzeManden",
            R.raw.johnz_short_hereisjohnny,
            listOf(
                R.raw.jonas_long_tubabrothers,
                R.raw.johnz_long_mistymountains
                ),
            "",
            image = R.drawable.senshi
        ),
        Cue(
            5,
            "Shop",
            R.raw.random_short_nice,
            listOf(R.raw.shop_long_elderscrolls),
            "",
            image = R.drawable.slay_shoopkeeper
        ),
        Cue(
            6,
            "SideQuest",
            0,
            listOf(R.raw.random_long_sidequest),
            "",
            image = R.drawable.sidequest
        )
    )

    //Promises to return a list of type Cue
    fun getCues(): List<Cue> {
        return cues
    }

}
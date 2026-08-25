package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.CueAnimation

class CueRepository {
    //making a list of private hardcodet properties

    private val cues = listOf(
        Cue(
            id = 1,
            name = "den udøvende magt",
            shortSound = R.raw.kristian_short_the_darkness,
            longSounds = listOf(
                R.raw.kristian_long_legendofsexy,
                R.raw.prince_hinata_long,
                R.raw.lesson_long,
                R.raw.kristian_long_sheksophone
            ),
            longTitle = " ",
            image = R.drawable.revenge,
            animation = CueAnimation.SHAKE
        ),
        Cue(
            2,
            "Vakuu",
            R.raw.handsomelegend_short,
            listOf(
                R.raw.crone_long_moge,
                R.raw.crone_long_mitchirineko_march,
                R.raw.penicillin_long,
                R.raw.wideputin_long
            ),
            "",
            image = R.drawable.vakuu,
            animation = CueAnimation.PULSE
        ),
        Cue(
            3,
            "Håbet",
            R.raw.wabuu_short,
            listOf(
                R.raw.lassen_long_svampebob,
                R.raw.lassen_long_mosan,
                R.raw.lassen_long_orchardofmine_instrumental,
                R.raw.gigachad_orchestral_long

            ),
            "",
            image = R.drawable.leende_ko_classic
        ),
        Cue(
            4,
            "JohnzeManden",
            R.raw.johnz_short_hereisjohnny,
            listOf(
                R.raw.madao_long,
                R.raw.johnz_long_mistymountains,
                R.raw.pingu_noot_long,
                R.raw.vitas_long
            ),
            "",
            image = R.drawable.senshi,
            animation = CueAnimation.WOBBLE
        ),
        Cue(
            5,
            "Shop",
            R.raw.random_short_nice,
            listOf(
                R.raw.shop_long_elderscrolls,
                R.raw.beedleshop_long
            ),
            "",
            image = R.drawable.slay_shoopkeeper,
            animation = CueAnimation.SPIN
        ),
        Cue(
            6,
            "SideQuest",
            0,
            listOf(R.raw.random_long_sidequest),
            "",
            image = R.drawable.sidequest,
            animation = CueAnimation.FASTBOUNCE
        )
    )

    //Promises to return a list of type Cue
    fun getCues(): List<Cue> {
        return cues
    }

}
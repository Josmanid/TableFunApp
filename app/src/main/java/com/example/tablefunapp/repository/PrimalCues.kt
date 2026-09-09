package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.CueAnimation
import com.example.tablefunapp.models.WeightedSound

val primalCues = listOf(
    Cue(
        id = 1,
        name = "Thor(eg)",
        shortSound = R.raw.mjolnir_bonk_short,
        longSounds = listOf(
            WeightedSound(R.raw.jormungandr)

        ),
        longTitle = " ",
        image = R.drawable.hammer,
        animation = CueAnimation.SHAKE
    ),
    Cue(
        2,
        "Ljonar",
        R.raw.alive,
        listOf(
            WeightedSound(R.raw.senator_armstrongtheme_long)
        ),
        "",
        image = R.drawable.shield,
        animation = CueAnimation.PULSE
    ),
    Cue(
        3,
        "Drusk",
        R.raw.hesbeginningtobelieve_short,
        listOf(
            WeightedSound(R.raw.safriduobongo_long)

        ),
        "",
        image = R.drawable.bongocat
    ),
    Cue(
        4,
        "Karah",
        R.raw.mymindstellingmeno_short,
        listOf(
            WeightedSound(R.raw.moonlightassassin_long)
        ),
        "",
        image = R.drawable.delta,
        animation = CueAnimation.FASTWOBBLE
    ),
    Cue(
        5,
        "Enemy",
        R.raw.hobbit_amfire_amdeath,
        listOf(
            WeightedSound(R.raw.bodyimprovementclubsountrack)
        ),
        "",
        image = R.drawable.smaug,
        animation = CueAnimation.WOBBLE
    ),
    Cue(
        6,
        "Cobbles",
        shortSound = R.raw.hello_adventurer,
        listOf(WeightedSound(R.raw.cobblestone)),
        "",
        image = R.drawable.cobbles,
        animation = CueAnimation.SPIN
    ),
)

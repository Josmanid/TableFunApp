package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.CueAnimation
import com.example.tablefunapp.models.WeightedSound


     val evershadeCues = listOf(
        Cue(
            id = 1,
            name = "den udøvende magt",
            shortSound = R.raw.kristian_short_the_darkness,
            longSounds = listOf(
                WeightedSound(R.raw.eminence_timeofwar_long, weight = 40),
                WeightedSound(R.raw.tobeherox_long, weight = 40),
                WeightedSound(R.raw.kristian_enemymetalpipe_long, weight = 20)
            ),
            longTitle = " ",
            image = R.drawable.gladkriger,
            animation = CueAnimation.SHAKE
        ),
        Cue(
            2,
            "Vakuu",
            R.raw.explosion_short,
            listOf(
                WeightedSound(R.raw.touhou_owenwashere_epic_long, weight = 40),
                WeightedSound(R.raw.silantyev_trickstertheme_long, weight = 40),
                WeightedSound(R.raw.vakuumyheart_flute_clipped_long, weight = 20)
            ),
            "",
            image = R.drawable.vakuu,
            animation = CueAnimation.PULSE
        ),
        Cue(
            3,
            "Håbet",
            R.raw.wingedhussars_short,
            listOf(
                WeightedSound(R.raw.skyrim_dragonborncomes_long, weight = 40),
                WeightedSound(R.raw.lassen_long_orchardofmine_instrumental, weight = 40),
                WeightedSound(R.raw.lassen_long_mosan, weight = 20)
            ),
            "",
            image = R.drawable.leende_ko_classic
        ),
        Cue(
            4,
            "JohnzeManden",
            R.raw.johnz_short_hereisjohnny,
            listOf(
                WeightedSound(R.raw.gunsofwagghhh_long, weight = 40),
                WeightedSound(R.raw.valhallacaling_long, weight = 40),
                WeightedSound(R.raw.pizza_spiderman_long, weight = 20)
            ),
            "",
            image = R.drawable.senshi,
            animation = CueAnimation.WOBBLE
        ),
        Cue(
            id = 5,
            name = "Rot",
            shortSound = R.raw.random_short_heheboi,
            longSounds = listOf(
                WeightedSound(R.raw.era_ameno_long, weight = 40),
                WeightedSound(R.raw.ratdance_long, weight = 40),
                WeightedSound(R.raw.hamtarojap_long, weight = 20)
            ),
            longTitle = " ",
            image = R.drawable.dorime_rat,
            animation = CueAnimation.BOUNCE
        ),
        Cue(
            id = 6,
            name = "Blank",
            shortSound = R.raw.gutgunug_short,
            longSounds = listOf(
                WeightedSound(R.raw.runninginthe90s_long, weight = 80),
                WeightedSound(R.raw.runninginthe90s_shittyflute_long, weight = 20)
            ),
            longTitle = " ",
            image = R.drawable.soy_blank,
            animation = CueAnimation.FASTESTBOUNCE
        ),
        Cue(
            7,
            "Shop",
            R.raw.shop_thankyoukindsir_short,
            listOf(
                WeightedSound(R.raw.shop_long_elderscrolls, weight = 40),
                WeightedSound(R.raw.beedleshop_long, weight = 40),
                WeightedSound(soundResId = R.raw.shop_pling_long, weight = 19)
            ),
            "",
            image = R.drawable.slay_shoopkeeper,
            animation = CueAnimation.SPIN
        ),
        Cue(
            8,
            "Camp",
            R.raw.campdivorced_short,
            listOf(
                WeightedSound(R.raw.baldursgate_iwanttolife_long, weight = 40),
                WeightedSound(R.raw.divinelaments_dos_long, weight = 40),
                WeightedSound(R.raw.aiscream_long, weight = 10)
            ),
            "",
            image = R.drawable.wither,
            animation = CueAnimation.SPIN
        ),
        Cue(
            9,
            "OverWorld",
            0,
            listOf(WeightedSound(R.raw.thefieldsofard_long)),
            "",
            image = R.drawable.skyrim_landscape,
            animation = CueAnimation.PULSE
        ),
        Cue(
            10,
            "SideQuest",
            0,
            listOf(WeightedSound(R.raw.random_long_sidequest)),
            "",
            image = R.drawable.sidequest,
            animation = CueAnimation.FASTBOUNCE
        )

    )


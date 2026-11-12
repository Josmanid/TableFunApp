package com.example.tablefunapp.repository

import com.example.tablefunapp.R
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.models.CueAnimation
import com.example.tablefunapp.models.WeightedSound


val evershadeCues = listOf(
    Cue(
        id = 1,
        name = "Maximillian",
        shortSound = R.raw.rumor_is_pegasus_louder,
        longSounds = listOf(
            WeightedSound(R.raw.eminence_timeofwar_long, weight = 40),
            WeightedSound(R.raw.tobeherox_long, weight = 40),
            WeightedSound(R.raw.kristian_enemymetalpipe_long, weight = 20),
            WeightedSound(R.raw.aiscream_long, shortcut = "otaku")
        ),
        longTitle = " ",
        image = R.drawable.maximillian,
        animation = CueAnimation.SHAKE
    ),
    Cue(
        2,
        "Aurum",
        R.raw.explosion_short,
        listOf(
            WeightedSound(R.raw.touhou_owenwashere_epic_long, weight = 40),
            WeightedSound(R.raw.silantyev_trickstertheme_long, weight = 40),
            WeightedSound(R.raw.vakuumyheart_flute_clipped_long, weight = 20),
            WeightedSound(R.raw.raphaelfinalact_bdg3_long, shortcut = "devil", randomizable = false)
        ),
        "",
        image = R.drawable.auram,
        animation = CueAnimation.PULSE
    ),
    Cue(
        3,
        "Håbet",
        R.raw.hesbeginningtobelieve_short,
        listOf(
            WeightedSound(R.raw.skyrim_dragonborncomes_long, weight = 40),
            WeightedSound(R.raw.lassen_long_orchardofmine_instrumental, weight = 40),
            WeightedSound(R.raw.lassen_long_mosan, weight = 20),
            WeightedSound(R.raw.lassen_long_mosan, shortcut = "mosan", randomizable = false),
        ),
        "",
        image = R.drawable.leende_ko_classic
    ),
    Cue(
        4,
        "Lil Jonz No!",
        R.raw.liljon_short_yeah,
        listOf(
            WeightedSound(R.raw.gunsofwagghhh_long, weight = 40),
            WeightedSound(R.raw.valhallacaling_long, weight = 40),
            WeightedSound(R.raw.pizza_spiderman_long, weight = 20),
            WeightedSound(R.raw.lazytowncooking_long, shortcut = "lillejohnz", randomizable = false)
        ),
        "",
        image = R.drawable.senshi,
        animation = CueAnimation.WOBBLE
    ),
    Cue(
        id = 5,
        name = "Sir Vitor",
        shortSound = R.raw.sir_vitor_short,
        longSounds = listOf(
            WeightedSound(R.raw.metal_crusher_long, weight = 47),
            WeightedSound(R.raw.robo_theme_long, weight = 47),
            WeightedSound(R.raw.pain_train_long, weight = 5)
        ),
        longTitle = " ",
        image = R.drawable.robot_sir,
        animation = CueAnimation.PULSE
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
        "Minions",
        0,
        listOf(
            WeightedSound(R.raw.twiste_force_long, weight = 40),
            WeightedSound(R.raw.dark_of_the_night_long, weight = 40),
            WeightedSound(R.raw.number_one_long, weight = 20)
        ),
        "",
        image = R.drawable.minions,
        animation = CueAnimation.BOUNCE
    ),
    Cue(
        8,
        "Elite Mob",
        0,
        listOf(
            WeightedSound(R.raw.enmerkar_forest_battle_long, weight = 95),
            WeightedSound(R.raw.riberhus, weight = 5)
        ),
        "",
        image = R.drawable.elite_mob,
        animation = CueAnimation.FASTBOUNCE
    ),
    Cue(
        9,
        "The BOSS",
        0,
        listOf(
            WeightedSound(R.raw.malzeno_battle_theme_long, weight = 95),
            WeightedSound(R.raw.riberhus, weight = 5)
        ),
        "",
        image = R.drawable.gladkriger,
        animation = CueAnimation.SHAKE
    ),
    Cue(
        10,
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
        11,
        "SideQuest",
        0,
        listOf(WeightedSound(R.raw.random_long_sidequest)),
        "",
        image = R.drawable.sidequest,
        animation = CueAnimation.FASTBOUNCE
    ),
    Cue(
        id = 12,
        name = "RIP <3",
        shortSound = R.raw.hamtaro_sad,
        longSounds = listOf(
            WeightedSound(R.raw.hamtaro_long_dansk, shortcut = "hamtaro", randomizable = false)
        ),
        longTitle = " ",
        image = R.drawable.askebunke_med_rotte,
        animation = CueAnimation.SPIN
    ),
)


package com.example.tablefunapp.models

import com.example.tablefunapp.R

const val NO_SOUND = 0
enum class CueAnimation { BOUNCE, FASTBOUNCE, PULSE, WOBBLE, SHAKE, SPIN }

data class WeightedSound(
    val soundResId: Int,
    val weight: Int = 1
)
data class Cue(
    val id: Int,
    val name: String,
    val shortSound: Int,
    val longSounds: List<WeightedSound>,
    val longTitle: String,
    val image: Int = R.drawable.vibecat,
    val animation: CueAnimation = CueAnimation.BOUNCE
)
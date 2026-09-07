package com.example.tablefunapp.models

import com.example.tablefunapp.R

data class Board(
    val id: Int,
    val name: String,
    val image: Int = R.drawable.vibecat,
    val cues: List<Cue>
)
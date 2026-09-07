package com.example.tablefunapp.models

import com.example.tablefunapp.R

data class Board(
    val id: Int,
    val name: String,
    val cues: List<Cue>,
    val image: Int = R.drawable.vibecat
)
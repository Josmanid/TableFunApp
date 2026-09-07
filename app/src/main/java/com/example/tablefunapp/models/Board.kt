package com.example.tablefunapp.models

data class Board(
    val id: Int,
    val name: String,
    val image: Int,
    val cues: List<Cue>
)
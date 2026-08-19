package com.example.tablefunapp.models
const val NO_SOUND = 0
data class Cue(
    val id: Int,
    val name: String,
    val shortSound: Int,
    val longSound: Int,
    val longTitle: String
)
package com.example.tablefunapp.models

fun List<WeightedSound>.pickWeighted(): Int {
    val pool = filter { it. randomizable }
    if (pool.isEmpty()) return last().soundResId

    val total = pool.sumOf { it.weight } // like 5 or 100..
    var pick = (0 until total).random() // random number between 0 and 4: 3

    for (sound in pool) {
        pick -= sound.weight
        if (pick < 0) return sound.soundResId
    }
    return pool.last().soundResId
}
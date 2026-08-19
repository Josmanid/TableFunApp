package com.example.tablefunapp

sealed class NavRoutes(val route: String) {
    object SongSearch : NavRoutes("Songsearch")
    object SoundBoard : NavRoutes("Soundboard")
}
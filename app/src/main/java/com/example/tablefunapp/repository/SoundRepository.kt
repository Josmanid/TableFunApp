package com.example.tablefunapp.repository

import android.content.Context
import android.media.MediaPlayer

class SoundRepository(private val context: Context) {

    private var player: MediaPlayer? = null

    fun play(soundResId: Int) {
        stop()
        player = MediaPlayer.create(context, soundResId)
        player?.start()
    }

    fun stop() {
        player?.release() //otherwise it runs dry
        player = null
    }
}
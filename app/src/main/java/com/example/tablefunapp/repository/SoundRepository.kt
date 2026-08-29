package com.example.tablefunapp.repository

import android.content.Context
import android.media.MediaPlayer

class SoundRepository(private val context: Context) {

    private var longPlayer: MediaPlayer? = null
    private var shortPlayer: MediaPlayer? = null
    fun playLong(soundResId: Int, onFinished: () -> Unit = {}) {
        stopLong()
        longPlayer = MediaPlayer.create(context, soundResId)
        longPlayer?.setOnCompletionListener { onFinished() }
        longPlayer?.isLooping = true
        longPlayer?.start()
    }

    // need to do 3 things: 1. turn down the long 2. play the short sound 3. turn up the long song gain
    fun playShort(soundResId: Int, onFinished: () -> Unit = {}) {
        stopShort() // releases the system resources

        longPlayer?.setVolume(0.5f,0.5f) // turn down both audio channels

        shortPlayer = MediaPlayer.create(context, soundResId) // create instance for the given song found by id
        shortPlayer?.setOnCompletionListener { //when the listener is observing stop of short
            longPlayer?.setVolume(1f,1f) // then turn up the long sound
            stopShort()
        }
        shortPlayer?.start()

    }

    fun stopLong() {
        longPlayer?.release() //otherwise it runs dry
        longPlayer = null
    }

    fun stopShort() {
        shortPlayer?.release()
        shortPlayer = null
    }


}
package com.example.tablefunapp.models

data class ShortcutMatch(val cue: Cue, val soundResId: Int)

fun List<Cue>.matchShortcut(buffer: String): ShortcutMatch? {
    for (cue in this) {
        val sound = cue.longSounds.firstOrNull {
            it.shortcut.isNotBlank() && buffer.endsWith(it.shortcut)
        }
        if (sound != null) return ShortcutMatch(cue, sound.soundResId)
    }
    return null
}
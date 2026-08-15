package com.example.tablefunapp.screens

import android.os.Message
import androidx.compose.ui.Modifier
import com.example.tablefunapp.models.Song

class SongSearch(
    songs: List<Song>,
    modifier: Modifier = Modifier,
    errorMessage: String = "",
    songsLoading: Boolean = false,
    onSearch: (String) -> Unit = {}
) {
}
package com.example.tablefunapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tablefunapp.models.Song
import com.example.tablefunapp.repository.YouTubeRepository

class SongSearchViewModel : ViewModel() {

    //The viewModel holds States
    private val repository = YouTubeRepository()
    val songs: MutableState<List<Song>> = mutableStateOf(listOf())
    val isLoadingSongs = mutableStateOf(false)
    val errorMessage = mutableStateOf("")

    fun search(query: String) {

        isLoadingSongs.value = true //Start loading
        errorMessage.value = "" // fresh error before call
        repository.searchSong(
            query,
            onResult = { result ->
                songs.value = result
                isLoadingSongs.value = false
            },
            onError = { message ->
                errorMessage.value = message
                isLoadingSongs.value = false
            }
        )

    }


}
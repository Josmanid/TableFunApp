package com.example.tablefunapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tablefunapp.models.Board
import com.example.tablefunapp.repository.BoardRepository

class BoardViewModel : ViewModel() {

    private val boardRepository = BoardRepository()

    val boards = mutableStateOf<List<Board>>(emptyList())

    init {
        boards.value = boardRepository.getBoards()
    }
}
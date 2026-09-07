package com.example.tablefunapp.repository

import com.example.tablefunapp.models.Board
import com.example.tablefunapp.R

class BoardRepository {

    private val boards = listOf(
        Board(
            id = 1,
            name = "Land og Evershade",
            image = R.drawable.vibecat,
            cues = evershadeCues

        ),
        Board(
            id = 2,
            name = "Primal",
            image = R.drawable.vibecat,
            cues = emptyList()
        ),
        Board(
            id = 3,
            name = "Skyrim",
            image = R.drawable.vibecat,
            cues = emptyList()
        )
    )


    fun getBoards(): List<Board> {
        return boards
    }
}
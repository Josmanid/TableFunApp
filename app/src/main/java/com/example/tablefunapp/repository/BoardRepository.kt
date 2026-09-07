package com.example.tablefunapp.repository

import com.example.tablefunapp.models.Board
import com.example.tablefunapp.R

class BoardRepository {

    private val boards = listOf(
        Board(
            id = 1,
            name = "Land og Evershade",
            image = R.drawable.evershade,
            cues = evershadeCues

        ),
        Board(
            id = 2,
            name = "Primal",
            image = R.drawable.primal,
            cues = primalCues
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
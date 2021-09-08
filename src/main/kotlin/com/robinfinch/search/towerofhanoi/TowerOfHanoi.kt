package com.robinfinch.search.towerofhanoi

import com.robinfinch.search.SearchProblem
import com.robinfinch.search.towerofhanoi.Board.Companion.NUMBER_OF_PEGS

class TowerOfHanoi(numberOfDisks: Int) : SearchProblem<Board, Move>(
    initialState = Board(numberOfDisks),
    successorFunction = { state ->
        (0 until NUMBER_OF_PEGS).flatMap { pegFrom ->
            (0 until NUMBER_OF_PEGS).mapNotNull { pegTo ->
                state.checkValidMove(pegFrom, pegTo)
            }
        }.associateWith { state.execute(it) }
    },
    costFunction = { state, action -> 1 },
    goalFunction = { state -> state.pegs.last().disks.size == numberOfDisks }
)
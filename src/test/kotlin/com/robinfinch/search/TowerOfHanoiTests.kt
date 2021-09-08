package com.robinfinch.search

import com.robinfinch.search.strategy.BreadthFirstSearch
import com.robinfinch.search.towerofhanoi.TowerOfHanoi
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TowerOfHanoiTests {

    @Test
    fun breadthFirstSearch() {

        val towerOfHanoi = TowerOfHanoi(numberOfDisks =5)

        val solution = towerOfHanoi.search(BreadthFirstSearch()) ?: throw NullPointerException()

        assertEquals(31, solution.size)

        val goalState = solution.fold(towerOfHanoi.initialState) { board, move -> board.execute(move) }

        assertEquals(listOf(0, 1, 2, 3, 4), goalState.pegs.last().disks)
    }
}
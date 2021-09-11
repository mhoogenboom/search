package com.robinfinch.search.towerofhanoi

import com.robinfinch.search.strategy.informed.GreedySearch
import com.robinfinch.search.strategy.uninformed.BreadthFirstSearch
import com.robinfinch.search.strategy.uninformed.DepthFirstSearch
import com.robinfinch.search.strategy.uninformed.UniformCostSearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TowerOfHanoiTests {

    @Test
    fun breadthFirstSearch() {

        val towerOfHanoi = TowerOfHanoi(numberOfDisks = 5)

        val solution = towerOfHanoi.search(BreadthFirstSearch())

        assertEquals(31, solution.path?.size)
        assertEquals(31, solution.cost)
        assertEquals(242, solution.expandedNodes)

        val goalState = towerOfHanoi.apply(solution) ?: throw NullPointerException()

        assertEquals(listOf(0, 1, 2, 3, 4), goalState.pegs.last().disks)
    }

    @Test
    fun depthFirstSearch() {

        val towerOfHanoi = TowerOfHanoi(numberOfDisks = 5)

        val solution = towerOfHanoi.search(DepthFirstSearch())

        assertEquals(81, solution.path?.size) // not optimal
        assertEquals(81, solution.cost)
        assertEquals(1315, solution.expandedNodes)

        val goalState = towerOfHanoi.apply(solution) ?: throw NullPointerException()

        assertEquals(listOf(0, 1, 2, 3, 4), goalState.pegs.last().disks)
    }

    @Test
    fun uniformCostSearch() {
        // same as breadth first search when cost function = constant

        val towerOfHanoi = TowerOfHanoi(numberOfDisks = 5)

        val solution = towerOfHanoi.search(UniformCostSearch())

        assertEquals(31, solution.path?.size)
        assertEquals(31, solution.cost)
        assertEquals(242, solution.expandedNodes)

        val goalState = towerOfHanoi.apply(solution) ?: throw NullPointerException()

        assertEquals(listOf(0, 1, 2, 3, 4), goalState.pegs.last().disks)
    }

    @Test
    fun greedySearch() {
        val towerOfHanoi = TowerOfHanoi(numberOfDisks = 5)

        val strategy = GreedySearch<Board, Move> { node -> 5 - node.state.pegs.last().disks.size }

        val solution = towerOfHanoi.search(strategy)

        assertEquals(31, solution.path?.size)
        assertEquals(31, solution.cost)
        assertEquals(242, solution.expandedNodes)

        val goalState = towerOfHanoi.apply(solution) ?: throw NullPointerException()

        assertEquals(listOf(0, 1, 2, 3, 4), goalState.pegs.last().disks)
    }
}
package com.robinfinch.search.romaniatour

import com.robinfinch.search.strategy.informed.GreedySearch
import com.robinfinch.search.strategy.uninformed.BreadthFirstSearch
import com.robinfinch.search.strategy.uninformed.DepthFirstSearch
import com.robinfinch.search.strategy.uninformed.UniformCostSearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RomaniaTourTests {

    @Test
    fun breadthFirstSearch() {

        val romaniaTour = RomaniaTour()

        val solution = romaniaTour.search(BreadthFirstSearch())

        assertEquals(3, solution.path?.size)
        assertEquals(450, solution.cost) // not optimal
        assertEquals(8, solution.expandedNodes)

        val goalState = romaniaTour.apply(solution) ?: throw NullPointerException()

        assertEquals(RomaniaTour.bucharest, goalState)
    }

    @Test
    fun depthFirstSearch() {

        val romaniaTour = RomaniaTour()

        val solution = romaniaTour.search(DepthFirstSearch())

        assertEquals(7, solution.path?.size)
        assertEquals(733, solution.cost) // not optimal
        assertEquals(10, solution.expandedNodes)

        val goalState = romaniaTour.apply(solution) ?: throw NullPointerException()

        assertEquals(RomaniaTour.bucharest, goalState)
    }

    @Test
    fun uniformCostSearch() {

        val romaniaTour = RomaniaTour()

        val solution = romaniaTour.search(UniformCostSearch())

        assertEquals(4, solution.path?.size)
        assertEquals(418, solution.cost)
        assertEquals(12, solution.expandedNodes)

        val goalState = romaniaTour.apply(solution) ?: throw NullPointerException()

        assertEquals(RomaniaTour.bucharest, goalState)
    }

    @Test
    fun greedySearch() {

        val romaniaTour = RomaniaTour()

        val strategy = GreedySearch<Town, Road> { node -> node.state.distanceToBucharest }

        val solution = romaniaTour.search(strategy)

        assertEquals(3, solution.path?.size)
        assertEquals(450, solution.cost) // not optimal
        assertEquals(3, solution.expandedNodes)

        val goalState = romaniaTour.apply(solution) ?: throw NullPointerException()

        assertEquals(RomaniaTour.bucharest, goalState)
    }
}
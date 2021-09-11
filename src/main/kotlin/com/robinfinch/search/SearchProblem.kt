package com.robinfinch.search

import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State
import java.util.PriorityQueue

open class SearchProblem<S : State, A: Action>(
    val initialState: S,
    val successorFunction: (S) -> Map<A, S>,
    val costFunction: (S, A) -> Int,
    val goalFunction: (S) -> Boolean
) {

    fun search(strategy: Strategy<S, A>) : Solution<A> {

        val costPerState = mutableMapOf<S, Int>()

        val fringe = PriorityQueue(strategy)

        val root = SearchNode<S, A>(initialState)
        add(root, fringe, costPerState)

        var expandedNodes = 0

        while (fringe.isNotEmpty()) {
            val node = fringe.poll()

            if (goalFunction(node.state)) {
                return Solution(node.path, node.cost, expandedNodes)
            }

            expand(node, fringe, costPerState)

            expandedNodes++
        }

        return Solution(null, 0, expandedNodes)
    }

    private fun expand(node: SearchNode<S, A>, fringe: PriorityQueue<SearchNode<S, A>>, costPerState: MutableMap<S, Int>) {
        successorFunction(node.state).forEach { (action, state) ->
            val successor = SearchNode(
                node,
                action,
                state,
                node.cost + costFunction(state, action),
                node.depth + 1
            )
            add(successor, fringe, costPerState)
        }
    }

    private fun add(node: SearchNode<S, A>, fringe: PriorityQueue<SearchNode<S, A>>, costPerState: MutableMap<S, Int>) {

        val cost = costPerState[node.state]

        if ((cost != null) && (cost <= node.cost)) {
            // we already found a path to this state with a lower or equal cost
        } else {
            costPerState[node.state] = node.cost

            fringe.offer(node)
        }
    }

    fun apply(solution: Solution<A>): S? =
        solution.path?.fold(initialState) { state, action -> successorFunction(state).getValue(action) }
}
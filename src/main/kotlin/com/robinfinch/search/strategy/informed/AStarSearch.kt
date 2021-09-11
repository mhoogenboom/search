package com.robinfinch.search.strategy.informed

import com.robinfinch.search.SearchNode
import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

class AStarSearch<S : State, A: Action>(
    heuristicFunction: (SearchNode<S, A>) -> Int
) : BestFirstStrategy<S, A>(
    evaluationFunction = { node -> node.cost + heuristicFunction(node) }
)
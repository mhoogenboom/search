package com.robinfinch.search.strategy.informed

import com.robinfinch.search.SearchNode
import com.robinfinch.search.strategy.Strategy
import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

abstract class BestFirstStrategy<S : State, A : Action>(
    val evaluationFunction: (SearchNode<S, A>) -> Int
) : Strategy<S, A> {

    override fun compare(n1: SearchNode<S, A>, n2: SearchNode<S, A>): Int =
        evaluationFunction(n1) - evaluationFunction(n2)
}
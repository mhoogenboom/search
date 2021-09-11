package com.robinfinch.search.strategy.uninformed

import com.robinfinch.search.SearchNode
import com.robinfinch.search.strategy.Strategy
import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

class UniformCostSearch<S : State, A : Action> : Strategy<S, A> {

    override fun compare(n1: SearchNode<S, A>, n2: SearchNode<S, A>): Int =
        n1.cost - n2.cost
}
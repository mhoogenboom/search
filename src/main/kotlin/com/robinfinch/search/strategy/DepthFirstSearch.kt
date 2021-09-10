package com.robinfinch.search.strategy

import com.robinfinch.search.SearchNode
import com.robinfinch.search.Strategy
import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

class DepthFirstSearch<S : State, A : Action> : Strategy<S, A> {

    override fun compare(n1: SearchNode<S, A>, n2: SearchNode<S, A>): Int =
        n2.depth - n1.depth
}
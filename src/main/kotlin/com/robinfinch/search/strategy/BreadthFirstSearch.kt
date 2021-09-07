package com.robinfinch.search.strategy

import com.robinfinch.search.SearchNode
import com.robinfinch.search.Strategy
import com.robinfinch.search.statespace.State

class BreadthFirstSearch<S: State> : Strategy<S> {

    override fun compare(n1: SearchNode<S>, n2: SearchNode<S>): Int =
        n1.depth - n2.depth
}
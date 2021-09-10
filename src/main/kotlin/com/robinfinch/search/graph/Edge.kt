package com.robinfinch.search.graph

import com.robinfinch.search.statespace.Action

interface Edge<N> : Action {
    val from: N
    val to: N
}

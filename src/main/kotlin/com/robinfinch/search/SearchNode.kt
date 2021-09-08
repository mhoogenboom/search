package com.robinfinch.search

import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

data class SearchNode<S : State, A: Action>(
    val parent: SearchNode<S, A>?,
    val action: A?,
    val state: S,
    val cost: Int,
    val depth: Int
) {
    constructor(state: S) : this(null, null, state, 0, 0)

    val path: List<A>
      get() = if ((parent == null) || (action == null)) {
          emptyList()
      } else {
          parent.path + action
      }
}
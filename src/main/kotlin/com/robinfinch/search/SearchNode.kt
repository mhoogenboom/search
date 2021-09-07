package com.robinfinch.search

import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

data class SearchNode<S : State>(
    val parent: SearchNode<S>?,
    val action: Action?,
    val state: S,
    val cost: Int,
    val depth: Int
) {
    constructor(state: S) : this(null, null, state, 0, 0)

    val path: List<Action>
      get() = if ((parent == null) || (action == null)) {
          emptyList()
      } else {
          parent.path + action
      }
}
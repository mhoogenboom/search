package com.robinfinch.search.strategy

import com.robinfinch.search.SearchNode
import com.robinfinch.search.statespace.Action
import com.robinfinch.search.statespace.State

interface Strategy<S : State, A : Action> : Comparator<SearchNode<S, A>>
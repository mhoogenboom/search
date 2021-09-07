package com.robinfinch.search

import com.robinfinch.search.statespace.State

interface Strategy<S : State> : Comparator<SearchNode<S>> {
}
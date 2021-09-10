package com.robinfinch.search

import com.robinfinch.search.statespace.Action

data class Solution<A : Action>(
    val path: List<A>?,
    val expandedNodes: Int
)
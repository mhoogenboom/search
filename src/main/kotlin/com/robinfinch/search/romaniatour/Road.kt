package com.robinfinch.search.romaniatour

import com.robinfinch.search.graph.Edge

data class Road(
    override val from: Town,
    override val to: Town,
    val distance: Int
) : Edge<Town>

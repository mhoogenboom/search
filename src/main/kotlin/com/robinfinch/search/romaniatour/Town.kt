package com.robinfinch.search.romaniatour

import com.robinfinch.search.graph.Node

data class Town(
    val name: String,
    val distanceToBucharest: Int,
) : Node<Road>()

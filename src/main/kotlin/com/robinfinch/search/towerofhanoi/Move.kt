package com.robinfinch.search.towerofhanoi

import com.robinfinch.search.statespace.Action

data class Move(
    val from: Int,
    val to: Int
) : Action
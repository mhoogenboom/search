package com.robinfinch.search.graph

import com.robinfinch.search.statespace.State

open class Node<E> : State {
    val edges = mutableSetOf<E>()
}

package com.robinfinch.search.graph

class Graph<N : Node<E>, E : Edge<N>> {

    private val nodes = mutableSetOf<N>()

    fun node(node: N): Graph<N, E> {
       nodes.add(node)
       return this
    }

    fun edge(edge: E): Graph<N, E> {
        edge.apply {
            from.edges.add(this)
            // to.edges.add(this)
        }
        return this
    }

    fun createSuccessorFunction(): (N) -> Map<E, N> {
        return { node ->
            node.edges.associateWith { edge -> edge.to }
        }
    }
}

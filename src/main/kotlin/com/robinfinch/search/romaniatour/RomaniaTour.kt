package com.robinfinch.search.romaniatour

import com.robinfinch.search.SearchProblem
import com.robinfinch.search.graph.Graph

class RomaniaTour : SearchProblem<Town, Road>(
    initialState = arad,
    successorFunction = romania.createSuccessorFunction(),
    costFunction = { town, road -> road.distance },
    goalFunction = { town -> town == bucharest }
) {
    companion object {

        val arad = Town("Arad", 366)
        val bucharest = Town("Bucharest", 0)
        val craiova = Town("Craiova", 160)
        val drobeta = Town("Drobeta", 242)
        val fagaras = Town("Fagaras", 176)
        val lugoj = Town("Lugoj", 244)
        val mehadia = Town("Mehadia", 241)
        val oradea = Town("Oradea", 380)
        val pitesti = Town("Pitesti", 100)
        val rimnicu = Town("Rimnicu Vilcea", 193)
        val sibiu = Town("Sibiu", 253)
        val timisoara = Town("Timisoara", 329)
        val zerind = Town("Zerind", 374)

        val romania = Graph<Town, Road>()
            .node(oradea)
            .node(zerind)
            .node(arad)
            .node(timisoara)
            .node(lugoj)
            .node(mehadia)
            .node(drobeta)
            .node(sibiu)
            .node(rimnicu)
            .node(craiova)
            .node(fagaras)
            .node(pitesti)
            .node(bucharest)
            .edge(Road(oradea, zerind, 71))
            .edge(Road(oradea, sibiu, 151))
            .edge(Road(zerind, oradea, 71))
            .edge(Road(zerind, arad, 75))
            .edge(Road(arad, zerind, 75))
            .edge(Road(arad, sibiu, 140))
            .edge(Road(arad, timisoara, 118))
            .edge(Road(timisoara, arad, 118))
            .edge(Road(timisoara, lugoj, 111))
            .edge(Road(lugoj, timisoara, 111))
            .edge(Road(lugoj, mehadia, 70))
            .edge(Road(mehadia, lugoj, 70))
            .edge(Road(mehadia, drobeta, 75))
            .edge(Road(drobeta, mehadia, 75))
            .edge(Road(drobeta, craiova, 120))
            .edge(Road(sibiu, oradea, 151))
            .edge(Road(sibiu, arad, 140))
            .edge(Road(sibiu, rimnicu, 80))
            .edge(Road(sibiu, fagaras, 99))
            .edge(Road(rimnicu, sibiu, 80))
            .edge(Road(rimnicu, craiova, 146))
            .edge(Road(rimnicu, pitesti, 97))
            .edge(Road(craiova, drobeta, 120))
            .edge(Road(craiova, rimnicu, 146))
            .edge(Road(craiova, pitesti, 138))
            .edge(Road(fagaras, sibiu, 99))
            .edge(Road(fagaras, bucharest, 211))
            .edge(Road(pitesti, rimnicu, 97))
            .edge(Road(pitesti, craiova, 138))
            .edge(Road(pitesti, bucharest, 101))
    }
}
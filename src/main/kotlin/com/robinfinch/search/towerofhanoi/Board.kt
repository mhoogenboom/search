package com.robinfinch.search.towerofhanoi

import com.robinfinch.search.statespace.State

data class Board(
    val pegs: List<Peg>
) : State {

    constructor(numberOfDisks: Int) : this(
        (0 until NUMBER_OF_PEGS).map { pegNo ->
            if (pegNo == 0) {
                Peg((0 until numberOfDisks).toList())
            } else {
                Peg(emptyList())
            }
        }
    )

    fun checkValidMove(pegFrom: Int, pegTo: Int): Move? {
        val from = pegs[pegFrom]

        if (from.disks.isNotEmpty()) {
            val to = pegs[pegTo]

            if (to.disks.isEmpty() || (to.top() > from.top())) {
                return Move(pegFrom, pegTo)
            }
        }
        return null
    }

    fun execute(move: Move): Board {
        val disk = pegs[move.from].top()
        return Board(
            (0 until NUMBER_OF_PEGS).map { pegNo ->
                when (pegNo) {
                    move.from -> pegs[pegNo].take()
                    move.to -> pegs[pegNo].put(disk)
                    else -> pegs[pegNo]
                }
            }
        )
    }

    override fun toString(): String {
        val maxHeight = pegs.maxOf { it.disks.size }
        return (maxHeight downTo 1).map { height ->
            pegs
                .map { peg ->
                    if (height > peg.disks.size) {
                        "     "
                    } else {
                        "    ${peg.disks[peg.disks.size - height]} "
                    }
                }
                .map { it.drop(it.length - 4) }
                .joinToString(separator = "|")
        }.joinToString(separator = "\n")
    }

    companion object {
        val NUMBER_OF_PEGS = 3
    }
}

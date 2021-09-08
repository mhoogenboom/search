package com.robinfinch.search.towerofhanoi

data class Peg(
    val disks: List<Int>
) {
    fun top(): Int =
        disks.first()
    
    fun take(): Peg =
        Peg(disks.drop(1))
    
    fun put(disk: Int): Peg =
        Peg(listOf(disk) + disks)
}

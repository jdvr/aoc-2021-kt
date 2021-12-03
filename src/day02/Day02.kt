package day02

import readLinesAs

data class Command(val direction: String, val amount: Int)


// What do you get if you multiply your final horizontal position by your final depth?
fun main() {
    val commands = readLinesAs("day02/Day02") {
        val (command, amount) = it.trim().split(" ")
        Command(command, amount.toInt())
    }.toTypedArray()
    val (horizontal, depth) = calculatePosition(commands)
    println("$horizontal * $depth = ${horizontal * depth}")
}

fun calculatePosition(commands: Array<Command>): Pair<Int, Int> {
    return commands.fold(Pair(0,0)) { acc, command ->
        when (command.direction) {
            "forward" -> acc.copy(first = acc.first + command.amount)
            "down" -> acc.copy(second = acc.second + command.amount)
            "up" -> acc.copy(second = acc.second - command.amount)
            else -> acc
        }
    }
}



class Day02Test {

    fun `for test input returns 150`() {

    }
}

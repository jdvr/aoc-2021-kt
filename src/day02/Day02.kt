package day02

import readLinesAs

data class Command(val direction: String, val amount: Int)
data class Position(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0) {
    fun horizontalByDepth(): Int = horizontal * depth
}

// What do you get if you multiply your final horizontal position by your final depth?
fun main() {
    val commands = readLinesAs("day02/Day02") {
        val (command, amount) = it.trim().split(" ")
        Command(command, amount.toInt())
    }.toTypedArray()
    val (horizontal, depth) = calculatePosition(commands)
    println("$horizontal * $depth = ${horizontal * depth}")
    val positionWithAim = calculatePositionWithAim(commands)
    println("${positionWithAim.horizontal} * ${positionWithAim.depth} = ${positionWithAim.horizontalByDepth()}")
}

fun calculatePosition(commands: Array<Command>): Pair<Int, Int> {
    return commands.fold(Pair(0, 0)) { acc, command ->
        when (command.direction) {
            "forward" -> acc.copy(first = acc.first + command.amount)
            "down" -> acc.copy(second = acc.second + command.amount)
            "up" -> acc.copy(second = acc.second - command.amount)
            else -> acc
        }
    }
}

fun calculatePositionWithAim(commands: Array<Command>): Position {
    return commands.fold(Position()) { acc, command ->
        when (command.direction) {
            "forward" ->
                if (acc.aim == 0) {
                    acc.copy(horizontal = acc.horizontal + command.amount)
                } else {
                    acc.copy(horizontal = acc.horizontal + command.amount, depth = acc.aim * command.amount + acc.depth)
                }
            "down" -> acc.copy(aim = acc.aim + command.amount)
            "up" -> acc.copy(aim = acc.aim - command.amount)
            else -> acc
        }
    }
}

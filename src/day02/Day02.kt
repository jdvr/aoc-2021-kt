package day02

import readLinesAs


data class ThreeDimensionPosition(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0) {

    fun forward(amount: Int): ThreeDimensionPosition = if (aim == 0) {
        copy(horizontal = horizontal + amount)
    } else {
        copy(horizontal = horizontal + amount, depth = aim * amount + depth)
    }

    fun down(amount: Int): ThreeDimensionPosition = copy(aim = aim + amount)

    fun up(amount: Int): ThreeDimensionPosition = copy(aim = aim - amount)

    fun then(c: Command): ThreeDimensionPosition = c.on(this)

    fun horizontalByDepth(): Int = horizontal * depth

}

data class TwoDimensionPosition(val horizontal: Int = 0, val depth: Int = 0) {

    fun forward(amount: Int): TwoDimensionPosition = copy(horizontal = horizontal + amount)

    fun down(amount: Int): TwoDimensionPosition = copy(depth = depth + amount)

    fun up(amount: Int): TwoDimensionPosition = copy(depth = depth - amount)

    fun then(c: Command): TwoDimensionPosition = c.on(this)

    fun horizontalByDepth(): Int = horizontal * depth

}

typealias CFactory = (a: Int) -> Command

interface Command {
    fun amount(): Int
    fun on(p: ThreeDimensionPosition): ThreeDimensionPosition
    fun on(p: TwoDimensionPosition): TwoDimensionPosition
}

data class Forward(private val amount: Int) : Command {
    override fun amount(): Int = amount
    override fun on(p: ThreeDimensionPosition): ThreeDimensionPosition = p.forward(amount)
    override fun on(p: TwoDimensionPosition): TwoDimensionPosition = p.forward(amount)
}

data class Down(private val amount: Int) : Command {
    override fun amount(): Int = amount
    override fun on(p: ThreeDimensionPosition): ThreeDimensionPosition = p.down(amount)
    override fun on(p: TwoDimensionPosition): TwoDimensionPosition = p.down(amount)
}

data class Up(private val amount: Int) : Command {
    override fun amount(): Int = amount
    override fun on(p: ThreeDimensionPosition): ThreeDimensionPosition = p.up(amount)
    override fun on(p: TwoDimensionPosition): TwoDimensionPosition = p.up(amount)
}

val FactoryByCommandName = mapOf<String, CFactory>(
    "forward" to { Forward(it) },
    "down" to { Down(it) },
    "up" to { Up(it) }
)

fun calculatePosition(commands: Array<Command>): TwoDimensionPosition {
    return commands.fold(TwoDimensionPosition()) { acc, c ->
        acc.then(c)
    }
}

fun calculatePositionWithAim(commands: Array<Command>): ThreeDimensionPosition {
    return commands.fold(ThreeDimensionPosition()) { acc, c ->
        acc.then(c)
    }
}

fun mapLine(it: String): Command {
    val (command, amount) = it.trim().split(" ")
    return FactoryByCommandName[command]!!.invoke(amount.toInt())
}

// What do you get if you multiply your final horizontal position by your final depth?
fun main() {
    val commands = readLinesAs("day02/Day02") {
        mapLine(it)
    }.toTypedArray()

    val position = calculatePosition(commands)
    println("${position.horizontal} * ${position.depth} = ${position.horizontalByDepth()}")
    val positionWithAim = calculatePositionWithAim(commands)
    println("${positionWithAim.horizontal} * ${positionWithAim.depth} = ${positionWithAim.horizontalByDepth()}")
}


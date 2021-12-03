package day03

import readLinesAs

fun mapLine(line: String): Array<Int> = line.map { it.digitToInt() }.toTypedArray()

fun binToDecimal(binary: String): Int {
    println(binary)
    return binary.reversed().foldIndexed(0) { idx, acc, digit ->
        when (digit) {
            '1' -> acc + (1 shl (idx))
            else -> acc
        }
    }
}

fun gammaRate(numbers: Array<Array<Int>>): String {
    val numbersSizeHalf = numbers.size / 2
    val numberSize = numbers[0].size
    println(numberSize)
    val numbOfOnes = ArrayList<Int>(numberSize)
    for (num in numbers) {
        for (j in 0 until numberSize) {
            if (j >= numbOfOnes.size) {
                numbOfOnes.add(0)
            }
            if (num[j] == 1) {
                numbOfOnes[j] += 1
            }
        }
    }
    println(numbOfOnes)
    return numbOfOnes.map {
        if (it > numbersSizeHalf) {
            1
        } else {
            0
        }
    }.joinToString("")
}

fun epsilonRate(numbers: Array<Array<Int>>): String {
    val numbersSizeHalf = numbers.size / 2

    val numberSize = numbers[0].size
    val numbOfOnes = ArrayList<Int>(numberSize)
    for (num in numbers) {
        for (j in 0 until numberSize) {
            if (j >= numbOfOnes.size) {
                numbOfOnes.add(0)
            }
            if (num[j] == 1) {
                numbOfOnes[j] += 1
            }
        }
    }

    return numbOfOnes.map {
        if (it > numbersSizeHalf) {
            0
        } else {
            1
        }
    }.joinToString("")
}

fun main() {
    val input = readLinesAs("day03/Day03") {
        mapLine(it)
    }.toTypedArray()
    val g = gammaRate(input)
    val e = epsilonRate(input)
    println("${binToDecimal(g)} * ${binToDecimal(e)} = ${binToDecimal(g) * binToDecimal(e)}")

}


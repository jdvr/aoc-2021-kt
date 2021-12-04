package day03

import readLinesAs

fun mapLine(line: String): Array<Int> = line.map { it.digitToInt() }.toTypedArray()

fun binToDecimal(binary: String): Int {
    return binary.reversed().foldIndexed(0) { idx, acc, digit ->
        when (digit) {
            '1' -> acc + (1 shl (idx))
            else -> acc
        }
    }
}

fun gammaEpsilonRate(numbers: Array<Array<Int>>): Pair<String, String> {
    val numbersSizeHalf = numbers.size / 2
    val numbOfOnes = countNumberOfOnesByPosition(numbers)

    var g = ""
    var e = ""
    for (n in numbOfOnes) {
        if (n > numbersSizeHalf) {
            g += "1"
            e += "0"
        } else {
            g += "0"
            e += "1"
        }
    }
    return g to e
}

private fun countNumberOfOnesByPosition(numbers: Array<Array<Int>>): ArrayList<Int> {
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
    return numbOfOnes
}

private fun countNumberOfOnesAt(numbers: List<Array<Int>>, position: Int): Int {
    var numbOfOnes = 0
    for (num in numbers) {
        if (num[position] == 1) {
            numbOfOnes += 1
        }
    }
    return numbOfOnes
}

fun filterDiagnosisNumbers(numbers: Array<Array<Int>>, most: Boolean): Array<Int> {
    return filterDiagnosisNumbers(numbers.asList(), 0, most)
}

fun filterDiagnosisNumbers(remaining: List<Array<Int>>, expectedIdx: Int, most: Boolean): Array<Int> {
    if (remaining.size == 1) {
        return remaining[0]
    }
    val numberOfOnesAt = countNumberOfOnesAt(remaining, expectedIdx).toFloat()
    val remainignHalfSize = remaining.size / 2f
    val expected = when {
        most && numberOfOnesAt >= remainignHalfSize -> 1
        most && numberOfOnesAt < remainignHalfSize -> 0
        !most && numberOfOnesAt >= remainignHalfSize -> 0
        else -> 1
    }
    val r = remaining.filter { it[expectedIdx] == expected }
    return filterDiagnosisNumbers(r, expectedIdx + 1, most)
}

fun lifeSupportRating(numbers: Array<Array<Int>>): Pair<Int, Int> {
    val oxygenGeneratorRating = filterDiagnosisNumbers(numbers, true)
    val CO2ScrubberRating = filterDiagnosisNumbers(numbers, false)
    return binToDecimal(oxygenGeneratorRating.joinToString("")) to binToDecimal(CO2ScrubberRating.joinToString(""))
}

fun main() {
    val input = readLinesAs("day03/Day03") {
        mapLine(it)
    }.toTypedArray()
    val (g, e) = gammaEpsilonRate(input)
    println("${binToDecimal(g)} * ${binToDecimal(e)} = ${binToDecimal(g) * binToDecimal(e)}")
    println("-- Part Two ---")
    val (oxygenGeneratorRating, CO2ScrubberRating) = lifeSupportRating(input)
    println("${oxygenGeneratorRating} * ${CO2ScrubberRating} = ${CO2ScrubberRating * oxygenGeneratorRating}")
}


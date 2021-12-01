

fun main() {
    val input = readLinesAs("Day01") {
        it.toInt()
    }

    var part2Res = 0
    var currWindow = 0
    var prevWindow = 1
    val increasedMesCount = input.foldIndexed(0) { idx, acc, _ ->
        when {
            idx == 0 -> acc
            input[idx] > input[idx - 1] -> acc + 1
            else -> acc
        }
    }
    println(increasedMesCount)
}

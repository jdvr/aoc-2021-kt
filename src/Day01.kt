

fun main() {
    val input = readLinesAs("Day01") {
        it.toInt()
    }

    var part1Res = 0
    var part2Res = 0
    var currWindow = 0
    var prevWindow = Int.MAX_VALUE
    for (i in 1 until input.size) {
        if (input[i] > input[i-1]){
            part1Res++
        }
        if (i < 2) continue
        currWindow = input[i] + input[i-1] + input[i-2]
        if (currWindow > prevWindow) {
            part2Res++
        }
        prevWindow = currWindow
    }
    println(part1Res)
    println(part2Res)
}

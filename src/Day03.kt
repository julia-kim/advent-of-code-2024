import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val regex = """(mul\(\d+,\d+\))""".toRegex()
        val mulInstructions = regex.findAll(input.toString()).map {
           val instruction = it.groupValues[1]
           val (x,y) = instruction.replace("mul(", "").replace(")", "").split(",")
            x.toInt() * y.toInt()
        }
        return mulInstructions.sum()
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
//    check(part2(testInput) == 4)

    val input = readInput("Day03")
    part1(input).println()
//    part2(input).println()
}

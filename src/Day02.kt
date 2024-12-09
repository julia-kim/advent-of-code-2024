import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var safeReports = 0
        input.forEach report@{ report ->
            val numbers = report.split(" ").map { it.toInt() }.windowed(2, 1)
            val isIncrease = numbers[0][1] - numbers[0][0] > 0
            numbers.forEach {
                if (isIncrease) {
                    if (it[1] - it[0] > 3 || it[1] - it[0] < 1) return@report
                } else {
                    if (it[1] - it[0] < -3 || it[1] - it[0] > -1) return@report
                }
            }
            safeReports += 1
        }
        return safeReports
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
   check(part2(testInput) == 4)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun main() {
    fun part1(input: List<String>): Int {
        val listOne = mutableListOf<Int>()
        val listTwo = mutableListOf<Int>()
        input.forEach {
            val (first, second) = it.split("   ")
            listOne.add(first.toInt())
            listTwo.add(second.toInt())
        }
        listOne.sort()
        listTwo.sort()
        val differences = listOne.mapIndexed { i, num ->
            if (num == listTwo[i]) 0
            else if (num < listTwo[i]) listTwo[i] - num
            else num - listTwo[i]
        }
        return differences.sum()
    }

    fun part2(input: List<String>): Int {
        val listOne = mutableListOf<Int>()
        val listTwo = mutableListOf<Int>()
        input.forEach {
            val (first, second) = it.split("   ")
            listOne.add(first.toInt())
            listTwo.add(second.toInt())
        }
        var similarityScore = 0
        listOne.forEachIndexed { i, num ->
            val count = listTwo.count { it == num }
            similarityScore += num * count
        }
        return similarityScore
    }

//    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 11)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

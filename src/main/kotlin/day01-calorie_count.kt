import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main(args: Array<String>) {
    val file = File("input/day01-big.txt")
    try {
        BufferedReader(FileReader(file)).use { br ->
            var line: String?
            var sum = 0
            var max = Int.MIN_VALUE
            val elfCalories : MutableList<Int> = mutableListOf()
            while (br.readLine().also { line = it } != null) {
                if (line.equals("")) {
                    elfCalories.add(sum)
                    if (sum > max) max = sum
                    sum = 0
                } else {
                    sum += line?.toInt() ?: 0
                }
            }
            val sorted = elfCalories.sortedDescending()
            println("Max calories: $max")
            println()
            println("Top 3 combined: ${sorted[0] + sorted[1] + sorted[2]}")
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
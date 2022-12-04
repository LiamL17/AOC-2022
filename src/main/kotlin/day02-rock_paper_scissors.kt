import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main(args: Array<String>) {
    val file = File("input/day02.txt")
    try {
        BufferedReader(FileReader(file)).use { br ->
            var line: String?
            var sum1 = 0
            var sum2 = 0
            while (br.readLine().also { line = it } != null) {
                var game1 = 0
                var game2 = 0
                when (line) {
                    "A X" -> game1 = 3 + 1
                    "A Y" -> game1 = 6 + 2
                    "A Z" -> game1 = 0 + 3

                    "B X" -> game1 = 0 + 1
                    "B Y" -> game1 = 3 + 2
                    "B Z" -> game1 = 6 + 3

                    "C X" -> game1 = 6 + 1
                    "C Y" -> game1 = 0 + 2
                    "C Z" -> game1 = 3 + 3
                }

                when (line) {
                    "A X" -> game2 = 0 + 3
                    "A Y" -> game2 = 3 + 1
                    "A Z" -> game2 = 6 + 2

                    "B X" -> game2 = 0 + 1
                    "B Y" -> game2 = 3 + 2
                    "B Z" -> game2 = 6 + 3

                    "C X" -> game2 = 0 + 2
                    "C Y" -> game2 = 3 + 3
                    "C Z" -> game2 = 6 + 1
                }
                sum1 += game1
                sum2 += game2
            }

            println("Total points of all games played (pt1): $sum1")
            println("Total points of all games played (pt1): $sum2")
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
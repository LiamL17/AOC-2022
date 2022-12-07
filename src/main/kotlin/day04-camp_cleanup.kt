import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main() {
    val file = File("input/day04.txt")
    try {
        BufferedReader(FileReader(file)).use { br ->
            var totalPt1 = 0
            var totalPt2 = 0
            br.lines().forEach {
                val split = it.split(",")
                val leftSplit = split[0].split("-")
                val rightSplit = split[1].split("-")
                val low1 = leftSplit[0].toInt()
                val high1 = leftSplit[1].toInt()

                val low2 = rightSplit[0].toInt()
                val high2 = rightSplit[1].toInt()

                if ((low1 >= low2 && high1 <= high2) || (low2 >= low1 && high2 <= high1)) {
                    totalPt1++
                }

                if ((low1 in low2..high2) || (high1 in low2..high2) || (low2 in low1..high1) || (high2 in low1..high1)) {
                    totalPt2++
                }
            }
        println("Total fully overlap: $totalPt1")
        println("Total overlap: $totalPt2")
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
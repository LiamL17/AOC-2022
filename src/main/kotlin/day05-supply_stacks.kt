import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

private const val debug = false

fun main() {
    val file = File("input/day05.txt")
    val stacks = getStacks(file)
    val stacksWithOrder = getStacks(file)

    populateStacks(file, stacks)
    populateStacks(file, stacksWithOrder)

    println("Populated stacks $stacks")
    moveStacks(file, stacks)
    println("Final stacks $stacks")
    println("Top of each stack ${topOfEachStack(stacks)}\n")

    println("Populated stacks $stacksWithOrder")
    moveStacksWithSameOrder(file, stacksWithOrder)
    println("Final stacks with order persistence $stacksWithOrder")
    println("Top of each stack ${topOfEachStack(stacksWithOrder)}")
}

fun topOfEachStack(stacks: List<ArrayDeque<String>>) : String {
    var tops = ""

    for (stack in stacks) {
        tops += stack.last()
    }

    return tops
}

fun moveStacksWithSameOrder(file: File, stacks: List<ArrayDeque<String>>) {
    try {
        BufferedReader(FileReader(file)).use { br ->
            for (line in br.lines()) {
                if (line.isEmpty() || (line[0] != 'm')) continue

                val subLine = line.substring(startIndex = line.indexOf(" ") + 1)
                val howManyToMove = Integer.parseInt(subLine.substring(startIndex = 0, endIndex = subLine.indexOf(" ")))

                val from = Integer.parseInt(subLine[subLine.indexOf("f") + 5].toString()) - 1
                val to = Integer.parseInt(subLine[subLine.length - 1].toString()) - 1

                if (debug) println("move $howManyToMove from $from to $to")

                val stack = ArrayDeque<String>()
                for (i in 0 until howManyToMove) {
                    val pop = stacks[from].removeLast()
                    if (debug) println("Popped $pop")
                    stack.addLast(pop)
                }

                if (debug) println("Order contained stack $stack")

                for (i in 0 until howManyToMove) {
                    val pop = stack.removeLast()
                    stacks[to].addLast(pop)
                }

                if (debug) println("Stacks currently $stacks\n\n")
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun moveStacks(file: File, stacks: List<ArrayDeque<String>>) {
    try {
        BufferedReader(FileReader(file)).use { br ->
            for (line in br.lines()) {
                if (line.isEmpty() || (line[0] != 'm')) continue

                val subLine = line.substring(startIndex = line.indexOf(" ") + 1)
                val howManyToMove = Integer.parseInt(subLine.substring(startIndex = 0, endIndex = subLine.indexOf(" ")))

                val from = Integer.parseInt(subLine[subLine.indexOf("f") + 5].toString()) - 1
                val to = Integer.parseInt(subLine[subLine.length - 1].toString()) - 1

                if (debug) println("move $howManyToMove from $from to $to")

                for (i in 0 until howManyToMove) {
                    val pop = stacks[from].removeLast()
                    if (debug) println("Popped $pop")
                    stacks[to].addLast(pop)
                }

                if (debug) println("Stacks currently $stacks\n\n")
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun populateStacks(file: File, stacks: List<ArrayDeque<String>>) {
    try {
        BufferedReader(FileReader(file)).use { br ->
            for (line in br.lines()) {
                if (line[1].toString() == "1") {
                    return
                }

                var stackIndexInLine = 1
                while (stackIndexInLine < line.length ) {
                    val c = line[stackIndexInLine]
                    if (c == ' ') {
                        stackIndexInLine += 4
                        continue
                    }

                    val stackIndex = stackIndexInLine / 4
                    stacks[stackIndex].addFirst(line[stackIndexInLine].toString())

                    stackIndexInLine += 4
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun getStacks(file: File): List<ArrayDeque<String>> {
    val stacks = mutableListOf<ArrayDeque<String>>()
    try {
        BufferedReader(FileReader(file)).use { br ->
            for (line in br.lines()) {
                val numOfStacks: Int
                if (line[1].toString() == "1") {
                    numOfStacks = Integer.parseInt(line[line.length - 1].toString())

                    for (i in 0 until numOfStacks) {
                        stacks.add(ArrayDeque(listOf()))
                    }
                    return stacks
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return emptyList()
}
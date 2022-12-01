package main
import (
  "bufio"
  "fmt"
  "os"
  "sort"
  "strconv"
)

func main() {
  readFile, _ := os.Open("day01-big.txt")

  fileScanner := bufio.NewScanner(readFile)
  fileScanner.Split(bufio.ScanLines)
  var fileLines []string
  
    for fileScanner.Scan() {
        fileLines = append(fileLines, fileScanner.Text())
    }

  readFile.Close()
  elfCaloriesSum := []int {}
  var sum = 0

  for _, line := range fileLines {
      if line == "" {
        elfCaloriesSum = append(elfCaloriesSum, sum)
        sum = 0
      }
    value, _ := strconv.Atoi(line)
    sum += value
    }

  sort.Sort(sort.Reverse(sort.IntSlice(elfCaloriesSum)))

  fmt.Println("Sum of elf with most calories: ", elfCaloriesSum[0])
  fmt.Println("Sum of top 3 elves with most calories: ", elfCaloriesSum[0] + elfCaloriesSum[1] + elfCaloriesSum[2])
}

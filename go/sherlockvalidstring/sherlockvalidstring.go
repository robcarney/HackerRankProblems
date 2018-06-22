package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strings"
)

// Complete the isValid function below.
func isValid(s string) string {
	charMap := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		charMap[s[i]]++
	}
	currCount := -1
	usedPlusOne := false
	charCount := 0
	for _, v := range charMap {
		if currCount == -1 {
			currCount = v
			charCount++
		} else if currCount == v {
			charCount++
		} else if !usedPlusOne {
			if currCount+1 == v || v == 1 {
				usedPlusOne = true
			} else if (currCount-1 == v || currCount == 1) && charCount == 1 {
				currCount = v
				usedPlusOne = true
			} else {
				return "NO"
			}
			charCount++
		} else {
			return "NO"
		}
	}
	return "YES"
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	s := readLine(reader)

	result := isValid(s)

	fmt.Fprintf(writer, "%s\n", result)

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}

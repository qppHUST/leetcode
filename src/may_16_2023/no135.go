package main

import "fmt"

func main() {
	list := []int{1, 0, 2}
	ans := candy(list)
	fmt.Println(ans)
}

func candy(ratings []int) int {
	anslist := make([]int, len(ratings), len(ratings))
	anslist[0] = 1
	index := 1
	ans := 0
	for ; index < len(ratings); index++ {
		previous := ratings[index-1]
		now := ratings[index]
		if now > previous {
			lastCandy := anslist[index]
			anslist[index] = lastCandy + 1
		} else {
			lastCandy := anslist[index]
			anslist[index] = 1
			if lastCandy == 1 {
				increment(anslist, index-1)
			}
		}
	}
	for item, _ := range anslist {
		ans = ans + item
	}
	return ans
}

func increment(data []int, border int) {
	for i := border; i >= 0; i-- {
		data[i] = data[i] + 1
		if i == 0 || data[i-1] > data[i] {
			break
		}
	}
}

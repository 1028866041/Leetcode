//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例：
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
// Related Topics 回溯算法

package main

//Go：N 皇后
import "fmt"

func main() {
	fmt.Println(solveNQueens(4))
}

//leetcode submit region begin(Prohibit modification and deletion)
var solutions [][]string

func solveNQueens(n int) [][]string {
	solutions = [][]string{}
	queen := make([]int, n)
	for i := 0; i < n; i++ {
		queen[i] = -1
	}
	column := map[int]bool{}
	diagonals1, diagonals2 := map[int]bool{}, map[int]bool{}
	backtrack(queen, n, 0, column, diagonals1, diagonals2)
	return solutions
}

func backtrack(queen []int, n, row int, column, diagonals1, diagonals2 map[int]bool) {
	if row == n {
		board := generateBoard(queen, n)
		solutions = append(solutions, board)
		return
	}

	for i := 0; i < n; i++ {
		if column[i] {
			continue
		}
		//foreach diagonals
		if diagonals1[row-i] {
			continue
		}
		if diagonals2[row+i] {
			continue
		}
		queen[row] = i
		column[i] = true
		diagonals1[row-i], diagonals2[row+i] = true, true
		backtrack(queen, n, row+1, column, diagonals1, diagonals2)
		queen[row] = -1
		delete(column, i)
		delete(diagonals1, row-i)
		delete(diagonals2, row+i)
	}
}

func generateBoard(queen []int, n int) []string {
	board := []string{}
	for i := 0; i < n; i++ {
		row := make([]byte, n)
		for j := 0; j < n; j++ {
			row[j] = '.'
		}
		row[queen[i]] = 'Q'
		board = append(board, string(row))
	}
	return board
}

//leetcode submit region end(Prohibit modification and deletion)

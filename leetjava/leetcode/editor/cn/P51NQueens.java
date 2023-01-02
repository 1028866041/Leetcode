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
// 示例: 
//
// 输入: 4
//输出: [
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
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.*;

//Java：N皇后
public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
        System.out.println(solution.solveNQueens(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] queens= new int[n];
        Arrays.fill(queens,-1);
        backtrack(queens, n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    public void backtrack(int[] queens, int n, int row,
        Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row==n){
            List<String> ls= generate(queens, n);
            res.add(ls);
            return;
        }
        for(int i=0;i<n;i++){
            if(columns.contains(i))
                continue;
            if(diagonals1.contains(row-i))
                continue;
            if(diagonals2.contains(row+i))
                continue;
            queens[row]= i;
            columns.add(i);
            diagonals1.add(row-i);
            diagonals2.add(row+i);
            backtrack(queens, n,row+1, columns, diagonals1, diagonals2);
            queens[row]= -1;
            columns.remove(i);
            diagonals1.remove(row-i);
            diagonals2.remove(row+i);
        }
    }

    public List<String> generate(int[] queens, int n){
        List<String> board= new ArrayList<>();
        for(int i=0;i<queens.length;i++){
            char[] row= new char[n];
            Arrays.fill(row, '.');
            row[queens[i]]= 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
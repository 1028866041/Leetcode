//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 734 👎 0

package leetcode.editor.cn;

public class P79WordSearch{
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited= new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board, i,j, word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i,int j, String word, int idx) {
        if(board[i][j]!=word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
        boolean flag= false;
        visited[i][j]= true;
        //向board[i][j]四个方向回溯
        for(int[] dir: direction) {
            if(valid(board, i+dir[0],j+dir[1])&& !visited[i+dir[0]][j+dir[1]]){
                if(backtrack(board,i+dir[0],j+dir[1], word, idx+1)){
                    flag= true;
                    break;
                }
            }
        }
        //退到上一步
        visited[i][j]= false;
        return flag;
    }

    public boolean valid(char[][] board, int x, int y){
        return x>=0&& x< board.length && y>=0 && y<board[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
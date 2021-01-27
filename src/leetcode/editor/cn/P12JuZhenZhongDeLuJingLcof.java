//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 223 👎 0

 
package leetcode.editor.cn;
 
public class P12JuZhenZhongDeLuJingLcof{
     public static void main(String[] args) {
         // TO TEST
         Solution solution = new P12JuZhenZhongDeLuJingLcof().new Solution();
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
        for(int[] dir: direction) {
            if(valid(board, i+dir[0],j+dir[1])&& !visited[i+dir[0]][j+dir[1]]){
                if(backtrack(board,i+dir[0],j+dir[1], word, idx+1)){
                    flag= true;
                    break;
                }
            }
        }
        visited[i][j]= false;
        return flag;
    }

    public boolean valid(char[][] board, int x, int y){
        return x>=0&& x< board.length && y>=0 && y<board[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
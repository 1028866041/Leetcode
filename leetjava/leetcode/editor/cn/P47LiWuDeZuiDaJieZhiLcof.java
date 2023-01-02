//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 91 👎 0

package leetcode.editor.cn;

public class P47LiWuDeZuiDaJieZhiLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P47LiWuDeZuiDaJieZhiLcof().new Solution();
        System.out.println(solution.maxValue(new int[][]{{}}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid)  {
        int m= grid.length, n= grid[0].length;
        int[] dp= new int[n+1];
        for (int i= 1; i<= m; i++) {
            for (int j= 1; j<= n; j++) {
                dp[j]= Math.max(dp[j], dp[j-1]) + grid[i-1][j-1];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。 
//
// 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单
//元格中所有整数的乘积。 
//
// 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。 
//
// 注意，取余是在得到最大积之后执行的。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[-1,-2,-3],
//             [-2,-3,-3],
//             [-3,-3,-2]]
//输出：-1
//解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
// 
//
// 示例 2： 
//
// 输入：grid = [[1,-2,1],
//             [1,-2,1],
//             [3,-4,1]]
//输出：8
//解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
// 
//
// 示例 3： 
//
// 输入：grid = [[1, 3],
//             [0,-4]]
//输出：0
//解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
// 
//
// 示例 4： 
//
// 输入：grid = [[ 1, 4,4,0],
//             [-2, 0,0,1],
//             [ 1,-1,1,1]]
//输出：2
//解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 15 
// -4 <= grid[i][j] <= 4 
// 
// Related Topics 贪心算法 动态规划 
// 👍 21 👎 0

package leetcode.editor.cn;
 
public class P1594MaximumNonNegativeProductInAMatrix{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1594MaximumNonNegativeProductInAMatrix().new Solution();
        System.out.println(solution.maxProductPath(new int[][]{{1, 3},{0,-4}}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProductPath(int[][] grid){
        int mod= 1000000000+7;
        int m= grid.length,n=grid[0].length;
        long[][] max= new long[m][n];
        long[][] min= new long[m][n];

        max[0][0]= min[0][0]= grid[0][0];
        for(int i=1;i<m;i++)
            max[i][0]= min[i][0]= max[i-1][0]*grid[i][0];
        for(int i=1;i<n;i++)
            max[0][i]= min[0][i]= max[0][i-1]*grid[0][i];

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                if(grid[i][j]>=0){
                    max[i][j]= Math.max(max[i][j-1], max[i-1][j])*grid[i][j];
                    min[i][j]= Math.min(min[i][j-1], min[i-1][j])*grid[i][j];
                }else{
                    max[i][j]= Math.min(min[i][j-1], min[i-1][j])*grid[i][j];
                    min[i][j]= Math.max(max[i][j-1], max[i-1][j])*grid[i][j];
                }
        if(max[m-1][n-1]<0){
            return -1;
        }else{
            return (int)(max[m-1][n-1]%mod);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
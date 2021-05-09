//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
// Related Topics 动态规划 
// 👍 41 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P08_02RobotInAGridLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P08_02RobotInAGridLcci().new Solution();
        System.out.println(solution.pathWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> ans= new ArrayList<>();
        if(obstacleGrid.length==0|| obstacleGrid[0].length==0||
            obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return ans;
        }
        backtrack(ans, obstacleGrid, 0,0, new boolean[obstacleGrid.length][obstacleGrid[0].length]);
        return ans;
    }

    public boolean backtrack(List<List<Integer>> ans, int[][] obstacleGrid, int i,int j, boolean[][] visited){
        if(i>=obstacleGrid.length||j>=obstacleGrid[0].length|| obstacleGrid[i][j]==1|| visited[i][j]){
            return false;
        }
        ans.add(Arrays.asList(i, j));
        visited[i][j]= true;
        if(i==obstacleGrid.length-1&& j==obstacleGrid[0].length-1){
            return true;
        }
        if(backtrack(ans, obstacleGrid, i+1,j,visited)|| backtrack(ans, obstacleGrid,i,j+1,visited)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
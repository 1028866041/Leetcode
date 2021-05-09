//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 193 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P417PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P417PacificAtlanticWaterFlow().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length==0|| matrix[0].length==0)
            return res;
        int[][] pacific= new int[matrix.length][matrix[0].length];
        int[][] atlantic= new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0)
                    traverse(matrix, pacific, i,j, matrix[i][j]);
                if(i==matrix.length-1|| j==matrix[0].length-1)
                    traverse(matrix, atlantic, i,j, matrix[i][j]);
            }
        }
        for(int i=0;i<matrix.length;i++) {
            for (int j=0; j<matrix[0].length;j++) {
                if(pacific[i][j]==1&&atlantic[i][j]==1)
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    public void traverse(int[][] matrix, int[][]visited, int i,int j, int pre){
        if(i<0||j<0||i>matrix.length-1||j>matrix[0].length-1
                ||visited[i][j]==1|| matrix[i][j]< pre)
            return;

        visited[i][j]= 1;
        traverse(matrix, visited, i-1,j, matrix[i][j]);
        traverse(matrix, visited, i+1,j, matrix[i][j]);
        traverse(matrix, visited, i,j-1, matrix[i][j]);
        traverse(matrix, visited, i,j+1, matrix[i][j]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 21 👎 0

 
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P01_08ZeroMatrixLcci{
     public static void main(String[] args) {
         // TO TEST
         Solution solution = new P01_08ZeroMatrixLcci().new Solution();
     }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j;

        List<int[]> l= new ArrayList<int[]>();
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    l.add(new int[]{i,j});
                }
            }
        }
        for(i=0;i<l.size();i++){
            for(j=0;j<matrix[0].length;j++){
                matrix[l.get(i)[0]][j]=0;
            }
            for(j=0;j<matrix.length;j++){
                matrix[j][l.get(i)[1]]=0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
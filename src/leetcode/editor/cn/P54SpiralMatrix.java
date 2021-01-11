//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 578 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
        List<Integer> l=solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        for(int i=0;i<l.size();i++)
            System.out.print(l.get(i)+" ");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        List<Integer> l= new ArrayList<Integer>();

        while(left<=right&& top<=bottom){
            int i=0;
            for(i=left;i<=right;i++){
                l.add(matrix[top][i]);
            }
            for(i=top+1;i<=bottom;i++){
                l.add(matrix[i][right]);
            }
            if(left<right && top<bottom){
                for(i=right-1;i>=left;i--){
                    l.add(matrix[bottom][i]);
                }
                for(i=bottom-1;i>=top+1;i--){
                    l.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 746 👎 0

package leetcode.editor.cn;
 
public class P48RotateImage{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P48RotateImage().new Solution();
        solution.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n/2;i++){
            for(int j=0;j<(n+1)/2;j++){
                int temp= matrix[i][j];
                //两步(i,j)->(j,n-1-i)->(n-1-i,n-1-j)
                matrix[i][j]= matrix[n-1-j][i];
                matrix[n-1-j][i]= matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]= matrix[j][n-1-i];
                matrix[j][n-1-i]= temp;
            }
        }
        /*
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。 
//
// 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 
//最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
//输出: [1,0,2]
//解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
// 
//
// 示例 2: 
//
// 输入:
//[
//   [0,1,1],
//   [1,0,1],
//   [1,1,0]
//]
//输出: [0,0,1]
// 
//
// 提示： 
//
// 
// matrix.length == matrix[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 17 👎 0

package leetcode.editor.cn;
 
public class P17_23MaxBlackSquareLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_23MaxBlackSquareLcci().new Solution();
        System.out.println(solution.findSquare(new int[][]{{0,1,1},{1,0,1},{1,1,0}})[0]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] matrix;
    int[][] xSum;
    int[][] ySum;
    public int[] findSquare(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        if(matrix.length == 1){
            if(matrix[0][0] == 0)
                return new int[] {0,0,1};
            else
                return new int[0];
        }
        int len = matrix.length;

        this.xSum = new int[len+1][len];
        this.ySum = new int[len][len+1];

        this.matrix = matrix;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len; ++j){
                ySum[i][j+1] = ySum[i][j] + matrix[i][j];
                xSum[j+1][i] = xSum[j][i] + matrix[j][i];
            }
        }
        int[] res = new int[3];

        for(int i = 0; i < len; ++i){
            if(len-i < res[2])
                break;

            for(int j = 0; j < len; ++j){
                if(len -j < res[2])
                    continue;
                if(matrix[i][j] == 0){
                    int l = traverse(i,j);
                    if(res[2] < l){
                        res[0] = i;
                        res[1] = j;
                        res[2] = l;
                    }
                }
            }
        }
        if(res[2] == 0)
            return new int[0];
        return res;
    }

    public int traverse(int x, int y){
        int l= 1;
        int ans= 1;
        while(x+l< matrix.length&& y+l< matrix.length){
            if(xSum[x+l+1][y]-xSum[x][y]== 0 && ySum[x][y+l+1]-ySum[x][y]== 0){
                if(xSum[x+l+1][y+l]-xSum[x][y+l]== 0 && ySum[x+l][y+l+1]-ySum[x+l][y]== 0)
                    ans = l+1;
            } else
                break;
            l++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
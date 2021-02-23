//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 40 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16_19PondSizesLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_19PondSizesLcci().new Solution();
        System.out.println(
            solution.pondSizes(new int[][]{{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] pondSizes(int[][] land) {
        List<Integer> s= new ArrayList<>();

        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                int sum= traverse(land, i,j);
                if(sum>0)
                    s.add(sum);
            }
        }
        int[] arry= new int[s.size()];
        for(int i=0;i<s.size();i++)
            arry[i]= s.get(i);
        Arrays.sort(arry);
        return arry;
    }

    public int traverse(int[][] land, int i, int j){
        if(i< 0|| i>= land.length|| j< 0|| j>=land[0].length||land[i][j]!=0)
            return 0;
        int num= 1;
        int[][] direction={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        land[i][j] = -1;
        for(int k=0;k<direction.length;k++){
            int si= i+direction[k][0];
            int sj= j+direction[k][1];
                num+= traverse(land, si, sj);
        }
        return num;
    }

    public boolean valid(int[][] land, int i,int j){
        return i>=0&&i< land.length&& j>=0&& j<land[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
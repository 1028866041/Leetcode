//给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。 
// 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小
//的直线返回，S[0]相同则选择S[1]值较小的直线返回。 
// 示例： 
// 输入： [[0,0],[1,1],[1,0],[2,0]]
//输出： [0,2]
//解释： 所求直线穿过的3个点的编号为[0,2,3]
// 
// 提示： 
// 
// 2 <= len(Points) <= 300 
// len(Points[i]) = 2 
// 
// Related Topics 几何 哈希表 
// 👍 10 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P16_14BestLineLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_14BestLineLcci().new Solution();
        System.out.println(solution.bestLine(new int[][]{{-38935,27124},{-39837,19604},{-7086,42194},{-11571,-23257},{115,-23257},{20229,5976},{24653,-18488},{11017,21043},{-9353,16550},{-47076,15237},{-36686,42194},{-17704,1104},{31067,7368},{-20882,42194},{-19107,-10597},{-14898,24506},{-20801,42194},{-52268,40727},{-14042,42194},{-23254,42194},{-30837,-53882},{1402,801},{-33961,-984},{-6411,42194},{-12210,22901},{-8213,-19441},{-26939,20810},{30656,-23257},{-27195,21649},{-33780,2717},{23617,27018},{12266,3608}}).length);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] bestLine(int[][] points) {
        int[] res = new int[2];
        int num= 0;
        int maxNum= 0;
        for(int i= 0; i< points.length-2; i++) {
            for(int j= i+1; j< points.length- 1; j++) {
                num = 2;
                if(points.length-j+1<= maxNum)
                    break;
                long x1 = points[j][0]- points[i][0];
                long y1 = points[j][1]- points[i][1];

                for (int k= j+1; k< points.length; k++) {
                    long x2 = points[k][0]- points[i][0];
                    long y2 = points[k][1]- points[i][1];
                    if (x1*y2 == x2*y1) num++;
                }
                if (num> maxNum) {
                    maxNum = num;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
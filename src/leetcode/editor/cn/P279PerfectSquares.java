//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 724 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P279PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        // TO TEST
        System.out.println(solution.numSquares(13));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<Integer> square= new HashSet<Integer>();

    public int numSquares(int n) {
        for(int i=0;i*i<=n;i++){
            square.add(i*i);
        }

        for(int i=1;i<=n;i++){
            if(divide(n,i))
                return i;
        }
        return 1;
    }

    public boolean divide(int n,int count){
        if(count==1){
            return square.contains(n);
        }
        for(Integer s:square){
            //贪心+递归
            if(divide(n-s, count-1))
                return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
public int numSquares(int n) {
    int[] dp= new int[n+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0]=0;

    int num=(int)Math.sqrt(n)+1;
    int square[]= new int[num];
    for(int i=1;i<num;i++){
        square[i]= i*i;
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<num;j++){
            if(i<square[j])
                break;
            //动态规划dp[i-square[j]]
            dp[i]= Math.min(dp[i], dp[i-square[j]]+1);
        }
    }
    return dp[n];
}
*/
}
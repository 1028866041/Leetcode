//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学 
// 👍 40 👎 0

package leetcode.editor.cn;
 
public class P17_09GetKthMagicNumberLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_09GetKthMagicNumberLcci().new Solution();
        System.out.println(solution.getKthMagicNumber(5));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp= new int[k];
        int p3,p5,p7;

        dp[0]=1;
        p3=p5=p7=0;
        for(int i=1;i<k;i++){
            dp[i]=  Math.min(Math.min(dp[p3]*3,dp[p5]*5),dp[p7]*7);
            if(dp[i]==dp[p3]*3){
                p3++;
            }
            if(dp[i]==dp[p5]*5){
                p5++;
            }
            if(dp[i]==dp[p7]*7){
                p7++;
            }
        }
        return dp[k-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
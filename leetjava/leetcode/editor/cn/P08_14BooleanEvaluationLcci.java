//给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)
// 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。 
//
// 示例 1: 
//
// 输入: s = "1^0|0|1", result = 0
//
//输出: 2
//解释: 两种可能的括号方法是
//1^(0|(0|1))
//1^((0|0)|1)
// 
//
// 示例 2: 
//
// 输入: s = "0&0&0&1^1|0", result = 1
//
//输出: 10 
//
// 提示： 
//
// 
// 运算符的数量不超过 19 个 
// 
// Related Topics 栈 字符串 
// 👍 29 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P08_14BooleanEvaluationLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P08_14BooleanEvaluationLcci().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] arr;
    int[][][] dp;
    public int countEval(String s, int result) {
        arr = s.toCharArray();
        dp= new int[s.length()][s.length()][2];
        for(int i=0;i<s.length();i++)
            for(int j=0;j<s.length();j++)
                Arrays.fill(dp[i][j], -1);
        return rec(0,s.length()-1,result);
    }

    public int rec(int start,int end,int result){
        if(start==end)
            return arr[start]-'0'==result?1:0;
        if(dp[start][end][result]!=-1)
            return dp[start][end][result];
        int count=0;
        for(int k=start;k<end;k+=2){
            char op= arr[k+1];
            for(int i=0;i<=1;i++)
                for(int j=0;j<=1;j++){
                    if(get(i,j,op)==result)
                        count+=rec(start,k,i)*rec(k+2,end,j);
                }
        }
        dp[start][end][result]= count;
        return count;
    }

    public int get(int v1,int v2, char op){
        switch(op){
            case '&':
                return v1&v2;
            case '|':
                return v1|v2;
            case '^':
                return v1^v2;
        }
        return v1&v2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
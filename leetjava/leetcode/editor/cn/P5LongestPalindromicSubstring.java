//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3074 👎 0

package leetcode.editor.cn;

public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("ab"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int i,j,k;
        boolean[][] dp= new boolean[s.length()][s.length()];
        String ans="";

        for(k=0;k<s.length();k++){
            for(i=0;i+k<s.length();i++){
                j=i+k;
                if(k==0){
                    dp[i][j]= true;
                }else if(k==1){
                    dp[i][j]= (s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]= dp[i+1][j-1]&& (s.charAt(i)==s.charAt(j));
                }

                if(dp[i][j] && ans.length()<k+1){
                    ans= s.substring(i,i+k+1);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
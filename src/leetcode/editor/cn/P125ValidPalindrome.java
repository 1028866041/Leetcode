//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


package leetcode.editor.cn;
//Java：验证回文串
public class P125ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        s= s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();
        int i=0,j=0,k=0;

        if(s.length()%2==0){
            j=s.length()/2-1;
            k=j+1;
            while(j>=0){
                if(s.charAt(j)!=s.charAt(k)){
                    return false;
                }
                j--;
                k++;
            }
        }else{
            j=s.length()/2-1;
            k=j+2;
            while(j>=0){
                if(s.charAt(j)!=s.charAt(k)){
                    return false;
                }
                j--;
                k++;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
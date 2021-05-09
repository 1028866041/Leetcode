//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 170 👎 0

package leetcode.editor.cn;
 
public class P46BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P46BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(12258));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        if(num<10)
            return 1;
        if(num%100>=10&& num%100<26){
            return translateNum(num/100)+translateNum(num/10);
        }else{
            return translateNum(num/10);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
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
 
public class P08_14BooleanEvaluationLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P08_14BooleanEvaluationLcci().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countEval(String s, int result) {

        throw new IllegalArgumentException("error");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
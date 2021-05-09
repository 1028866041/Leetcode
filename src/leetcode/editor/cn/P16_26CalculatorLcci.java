//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串 
// 👍 27 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class P16_26CalculatorLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_26CalculatorLcci().new Solution();
        System.out.println(solution.calculate("3+2*3/2"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        char[] ss= s.trim().replace(" ","").toCharArray();
        Stack<Integer> stack= new Stack<>();
        int res=0,i=0;
        while(i<ss.length) {
            int m=0;
            char tmp= ss[i];
            if(tmp=='*'|| tmp=='/'|| tmp=='+'|| tmp=='-'){
                i++;
            }
            while(i<ss.length&&Character.isDigit(ss[i])){
                m= m*10+ss[i]-'0';
                i++;
            }
            switch(tmp){
                case '*':
                    m= m*stack.pop();
                    break;
                case '/':
                    m= stack.pop()/m;
                    break;
                case '-':
                    m= -m;
                    break;
                default:
                    break;
            }
            stack.push(m);
        }
        while(!stack.isEmpty())
            res+= stack.pop();
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
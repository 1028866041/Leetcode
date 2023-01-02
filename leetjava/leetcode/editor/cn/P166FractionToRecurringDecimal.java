//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 
// 👍 196 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class P166FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new P166FractionToRecurringDecimal().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num= numerator;
        long den= denominator;
        String sign= "";
        if (num> 0 && den< 0 || num< 0 && den> 0) {
            sign= "-";
        }
        num= Math.abs(num);
        den= Math.abs(den);
        long integer= num/ den;
        num= num - integer * den;
        HashMap<Long, Integer> map= new HashMap<>();
        int index= 0;
        String decimal= "";
        int repeatIndex= -1;
        while(num!= 0){
            num*= 10;
            if(map.containsKey(num)){
                repeatIndex= map.get(num);
                break;
            }
            map.put(num, index);
            long decimalPlace= num/ den;
            decimal= decimal + decimalPlace;
            num-= decimalPlace * den;
            index++;
        }
        if (repeatIndex!= -1) {
            String dec= decimal;
            return sign+integer+"."+dec.substring(0, repeatIndex)+"("+dec.substring(repeatIndex) + ")";
        } else {
            if (decimal== "") {
                return sign+ integer;
            } else {
                return sign+ integer+ "." + decimal;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
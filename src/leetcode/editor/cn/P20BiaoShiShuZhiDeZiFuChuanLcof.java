//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 139 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P20BiaoShiShuZhiDeZiFuChuanLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P20BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        Map[] states = {
            new HashMap<Character,Integer>(){{put(' ', 0);put('s', 1);put('d', 2);put('.',4);}},
            new HashMap<Character,Integer>(){{put('d', 2);put('.', 4);}},
            new HashMap<Character,Integer>(){{put('d', 2);put('.', 3);put('e', 5);put(' ',8);}},
            new HashMap<Character,Integer>(){{put('d', 3);put('e', 5);put(' ', 8);}},
            new HashMap<Character,Integer>(){{put('d', 3);}},
            new HashMap<Character,Integer>(){{put('s', 6);put('d', 7);}},
            new HashMap<Character,Integer>(){{put('d', 7);}},
            new HashMap<Character,Integer>(){{put('d', 7);put(' ', 8);}},
            new HashMap<Character,Integer>(){{put(' ', 8);}}
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
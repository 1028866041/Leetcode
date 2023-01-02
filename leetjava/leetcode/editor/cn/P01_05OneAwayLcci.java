//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 49 👎 0

package leetcode.editor.cn;

import java.util.Map;

public class P01_05OneAwayLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P01_05OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("pale","ple"));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        if(first.length()<second.length()){
            return oneEditAway(second,first);
        }

        for(int i=0;i< second.length();i++){
            if(first.charAt(i)!=second.charAt(i)){
                return first.substring(i+1).equals(
                        second.substring(first.length()==second.length()?i+1:i));
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
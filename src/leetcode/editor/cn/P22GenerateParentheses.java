//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1505 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l= new ArrayList<String>();
        backtrack(new char[2*n],0, l);
        return l;
    }

    public void backtrack(char[] current, int pos, List<String> result ){
        if(pos==current.length){
            if(valid(current)){
                result.add(new String(current));
            }
        }else{
            current[pos]='(';
            backtrack(current,pos+1, result);
            current[pos]=')';
            backtrack(current, pos+1, result);
        }
    }

    public boolean valid(char[] current){
        int blance=0;
        for(char c:current){
            if(c=='('){
                blance++;
            }else{
                blance--;
                if(blance<0){
                    return false;
                }
            }
        }
        return blance==0?true:false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
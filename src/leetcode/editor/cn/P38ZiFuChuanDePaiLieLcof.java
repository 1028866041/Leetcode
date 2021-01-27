//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 160 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P38ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P38ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println(solution.permutation("dkjphedy"));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        List<String> res= new ArrayList<>();
        char[] array= s.toCharArray();
        Arrays.sort(array);
        backtrack(res, array, "", new boolean[s.length()]);
        return res.toArray(new String[0]);
    }

    public void backtrack(List<String> res, char[] s, String ls, boolean[] visited){
        if(ls.length()==s.length){
            res.add(new String(ls.toString()));
            return;
        }
        for(int i=0;i<s.length;i++){
            if(!visited[i]){
                if (i>0&& s[i]==s[i-1]&&!visited[i-1]){
                    continue;
                }
                visited[i]= true;
                ls+= s[i];
                backtrack(res, s, ls, visited);
                ls= ls.substring(0, ls.length()-1);
                visited[i]= false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
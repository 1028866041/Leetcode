//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 32 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P08_08PermutationIiLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P08_08PermutationIiLcci().new Solution();
        String[] l= solution.permutation("abb");
        for(int i=0;i<l.length;i++){
            System.out.println(l[i]);
        }
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String S) {
        List<String> ans= new ArrayList<>();
        backtrack(ans, S, new StringBuilder(),new boolean[S.length()]);
        return ans.toArray(new String[ans.size()]);
    }

    public void backtrack(List<String> ans, String s, StringBuilder sb, boolean[] visited){
        if(sb.length()==s.length()){
            //满足条件
            ans.add(sb.toString());
            return;
        }

        for(int i=0;i<s.length();i++){
            if(!visited[i]){
                boolean valid=true;
                for(int j=0;j<i;j++){
                    //相同层次去除
                    if(visited[j]&& s.charAt(i)==s.charAt(j)){
                        valid= false;
                    }
                }
                if(!valid)
                    continue;

                visited[i]= true;
                sb.append(s.charAt(i));
                //选择树dfs层次遍历
                backtrack(ans, s, sb,visited);
                //不满足条件回退上一步
                sb.deleteCharAt(sb.length()-1);
                visited[i]= false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
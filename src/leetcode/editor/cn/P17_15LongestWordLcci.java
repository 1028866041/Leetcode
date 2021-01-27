//给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符
//合要求的单词则返回空字符串。 
//
// 示例： 
//
// 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
//输出： "dogwalker"
//解释： "dogwalker"可由"dog"和"walker"组成。
// 
//
// 提示： 
//
// 
// 0 <= len(words) <= 200 
// 1 <= len(words[i]) <= 100 
// 
// Related Topics 字符串 
// 👍 16 👎 0

package leetcode.editor.cn;

import java.sql.Connection;
import java.util.*;

public class P17_15LongestWordLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_15LongestWordLcci().new Solution();
        System.out.println(solution.longestWord(new String[]{"vvbzbbzb","vvbzbbz","b","bb"}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestWord(String[] words) {
        List<String> ls= new ArrayList<>();
        Arrays.sort(words,(v1,v2)->v1.length()-v2.length());
        for(int i=0;i<words.length-1;i++){
            for(int j=i;j<words.length-1;j++) {
                for(int k=j+1;k<words.length;k++){
                    if(!ls.contains(words[k])){
                        String strs= new String(words[k]);
                        if(strs.contains(words[j])){
                            strs=strs.replace(words[j],"");
                        }
                        if(strs.contains(words[i])){
                            strs=strs.replace(words[i],"");
                        }
                        if(strs.equals(""))
                            ls.add(words[k]);
                    }
                }
            }
        }
        if(ls.size()>0){
            Collections.sort(ls, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length()==o2.length())
                        return o1.compareTo(o2);
                    else
                        return o2.length()-o1.length();
                }
            });
            return ls.get(0);
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
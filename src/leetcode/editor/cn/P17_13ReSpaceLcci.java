//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
// Related Topics 记忆化 字符串 
// 👍 162 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P17_13ReSpaceLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_13ReSpaceLcci().new Solution();
        System.out.println(solution.respace(new String[]{"looked","just","like","her","brother"},"jesslookedjustliketimherbrother"));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Trie{
        public Trie[] next;
        public boolean end;
        public Trie(){
            next= new Trie[26];
            end= false;
        }
        public void insert(String s){
            Trie cur= this;
            for(int i=s.length()-1;i>=0;i--){
                int j= s.charAt(i)-'a';
                if(cur.next[j]==null)
                    cur.next[j]= new Trie();
                cur= cur.next[j];
            }
            cur.end= true;
        }
    }

    public int respace(String[] dictionary, String sentence) {
        Trie root= new Trie();
        for(String w:dictionary)
            root.insert(w);
        int dp[]= new int[sentence.length()+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]= 0;
        for(int i=1;i<=sentence.length();i++){
            dp[i]= dp[i-1]+1;

            Trie cur= root;
            for(int j=i;j>=1;j--){
                int k=sentence.charAt(j-1)-'a';
                if(cur.next[k]==null)
                    break;
                else if(cur.next[k].end){
                    dp[i]= Math.min(dp[i],dp[j-1]);
                }
                if(dp[i]==0)
                    break;
                cur= cur.next[k];
            }
        }
        return dp[sentence.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
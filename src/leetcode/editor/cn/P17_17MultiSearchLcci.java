//给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字
//符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。 
//
// 示例： 
//
// 输入：
//big = "mississippi"
//smalls = ["is","ppi","hi","sis","i","ssippi"]
//输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
// 
//
// 提示： 
//
// 
// 0 <= len(big) <= 1000 
// 0 <= len(smalls[i]) <= 1000 
// smalls的总字符数不会超过 100000。 
// 你可以认为smalls中没有重复字符串。 
// 所有出现的字符均为英文小写字母。 
// 
// Related Topics 字典树 字符串 
// 👍 18 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_17MultiSearchLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_17MultiSearchLcci().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public class Trie{
        Trie[] next;
        boolean end;
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
        public void search(String s, Map<String,List<Integer>> map){
            Trie cur= this;
            StringBuilder build= new StringBuilder();
            for(int i=s.length()-1;i>=0;i--){
                int j= s.charAt(i)-'a';
                if(cur.next[j]==null)
                    break;
                build.insert(0,s.charAt(i));
                cur= cur.next[j];
                if(cur.end)
                    map.get(build.toString()).add(i);
            }
        }
    }
    public int[][] multiSearch(String big, String[] smalls) {
        Trie root= new Trie();
        Map<String,List<Integer>> map= new HashMap<>();
        for(String str:smalls){
            root.insert(str);
            map.put(str, new ArrayList<>());
        }

        for(int i=0;i<big.length();i++){
            root.search(big.substring(0,i+1), map);
        }
        int[][] res= new int[smalls.length][];
        for(int i=0;i<smalls.length;i++){
            res[i]= map.get(smalls[i]).stream().mapToInt(Integer::valueOf).toArray();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 深度优先搜索 广度优先搜索 数组 字符串 
// 👍 27 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P17_22WordTransformerLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_22WordTransformerLcci().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res= new ArrayList<>(),output= new ArrayList<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length()==0||endWord.length()==0)
            return res;
        backtrack(beginWord, endWord, wordList, new boolean[wordList.size()]);
        return res;
    }

    public void backtrack(String beginWord, String endWord, List<String> worldList, boolean[] visited){
        output.add(beginWord);
        Queue<String> queue= valid(beginWord, worldList, visited);
        for(String str:queue){
            if(str.equals(endWord)){
                output.add(str);
                res= new ArrayList<>(output);
                return;
            }
            backtrack(str, endWord, worldList, visited);
            output.remove(output.size()-1);
        }
    }

    public Queue<String> valid(String s, List<String> worldList, boolean[] visited){
        Queue<String> queue= new LinkedList<>();
        for(int i=0;i<worldList.size();i++){
            int cnt=0;
            if(worldList.get(i).length()!=s.length()||visited[i])
                continue;
            for(int j=0;j<worldList.get(i).length();j++){
                if(cnt>=2)
                    break;
                if(worldList.get(i).charAt(j)!=s.charAt(j))
                    cnt++;
            }
            if(cnt==1){
                queue.add(worldList.get(i));
                visited[i]= true;
            }
        }
        return queue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 双指针 字符串 
// 👍 17 👎 0

package leetcode.editor.cn;

public class P17_11FindClosestLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_11FindClosestLcci().new Solution();
        System.out.println(solution.findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"},"a","student"));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int res=Integer.MAX_VALUE;
        int idx=-1, idx2=-1;
        for(int i=0;i<words.length;i++) {
            if(words[i].equals(word1)){
                idx= i;
                if(idx2!=-1)
                    res= Math.min(res, Math.abs(idx-idx2));
            }
            if(words[i].equals(word2)){
                idx2= i;
                if(idx!=-1)
                    res= Math.min(res, Math.abs(idx-idx2));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
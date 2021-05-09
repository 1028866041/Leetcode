//在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你
//会得到一张含有有效单词的列表。映射如下图所示： 
//
// 
//
// 示例 1: 
//
// 输入: num = "8733", words = ["tree", "used"]
//输出: ["tree", "used"]
// 
//
// 示例 2: 
//
// 输入: num = "2", words = ["a", "b", "c", "d"]
//输出: ["a", "b", "c"] 
//
// 提示： 
//
// 
// num.length <= 1000 
// words.length <= 500 
// words[i].length == num.length 
// num中不会出现 0, 1 这两个数字 
// 
// Related Topics 数组 
// 👍 19 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P16_20T9Lcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_20T9Lcci().new Solution();
        System.out.println(solution.getValidT9Words("8733", new String[]{"tree", "used"}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> getValidT9Words(String num, String[] words) {
        HashMap<Integer, String> map= new HashMap();
        List<String> ans= new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        for(int k=0;k<words.length;k++){
            int i=0,j=0;
            while(i<num.length()){
                while(j<words[k].length() &&
                        map.get(Integer.parseInt(num.charAt(i)+"")).contains(words[k].charAt(j)+"")){
                    j++;
                }
                if(j>words[k].length()-1&& i>=num.length()-1){
                    i=0;
                    j=0;
                    ans.add(words[k]);
                    break;
                }
                i++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
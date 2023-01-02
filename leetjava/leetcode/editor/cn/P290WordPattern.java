//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 302 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P290WordPattern{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P290WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba","dog dog dog dog"));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map= new HashMap<>();
        Map<String, Character> maps= new HashMap<>();
        if(s.split(" ").length!=pattern.length())
            return false;
        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i))){
                for(Character key: map.keySet()){
                    if(map.get(key).equals(s.split(" ")[i]))
                        return false;
                }
                map.put(pattern.charAt(i), s.split(" ")[i]);
            }else{
                if(!map.get(pattern.charAt(i)).equals(s.split(" ")[i]))
                    return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
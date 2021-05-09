//给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。 
//
// 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：5
//解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：15
//解释：仅由元音组成的 15 个字典序字符串为
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
//注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
// 
//
// 示例 3： 
//
// 
//输入：n = 33
//输出：66045
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 33 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P1641CountSortedVowelStrings{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1641CountSortedVowelStrings().new Solution();
        System.out.println(solution.countVowelStrings(2));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans= 0;
    public int countVowelStrings(int n) {
        char[] nums= {'a','e','i','o','u'};
        bakctrack(nums, new ArrayList<>(),0,n);
        return ans;
    }

    public void bakctrack(char nums[], List<Character> ls, int idx, int n){
        if(ls.size()==n){
            ans++;
            return;
        }
        for(int i=idx;i<nums.length;i++){
            ls.add(nums[i]);
            bakctrack(nums, ls, i, n);
            ls.remove(ls.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
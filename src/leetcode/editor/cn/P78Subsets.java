//给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 936 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P78Subsets{
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> ls, int idx){
        ans.add(new ArrayList<>(ls));
        for(int i=idx;i<nums.length; i++){
            ls.add(nums[i]);
            backtrack(nums, ans, ls, i+1);
            ls.remove(ls.size()-1);
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
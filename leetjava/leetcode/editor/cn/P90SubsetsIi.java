//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 363 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        traverse(ans, nums, new ArrayList<>(), 0);
        return ans;
    }
    public void traverse(List<List<Integer>> ans, int[] nums, List<Integer> ls, int idx){
        ans.add(new ArrayList<Integer>(ls));
        for(int i=idx;i<nums.length;i++){
            if(i>idx&&nums[i]==nums[i-1])
                continue;
            ls.add(nums[i]);
            traverse(ans, nums, ls, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
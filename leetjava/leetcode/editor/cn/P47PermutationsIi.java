//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 557 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P47PermutationsIi{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P47PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,2,1}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        backtrack(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> ls, int[] nums, boolean[] visited){
        if(ls.size()==nums.length&& !ans.contains(ls)){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]= true;
                ls.add(nums[i]);
                backtrack(ans, ls, nums, visited);
                ls.remove(ls.size()-1);
                visited[i]= false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
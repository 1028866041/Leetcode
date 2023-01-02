//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 468 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
        List<List<Integer>> ans= solution.combinationSum2(new int[]{2,5,2,1,2},5);
        for(List l:ans){
            for(int i=0;i<l.size();i++){
                System.out.print(l.get(i)+" ");
            }
            System.out.println("");
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    public void backtrack( List<List<Integer>> res, int[] cand, int target, List<Integer> ls, int idx){
        if(target==0){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i< cand.length;i++){
            if(target-cand[i]<0)
                break;
            if(i>idx&& cand[i]==cand[i-1])
                continue;

            ls.add(cand[i]);
            backtrack(res, cand, target-cand[i], ls, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
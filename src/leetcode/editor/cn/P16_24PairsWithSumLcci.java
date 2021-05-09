//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 
// 👍 16 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P16_24PairsWithSumLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_24PairsWithSumLcci().new Solution();
        System.out.println(solution.pairSums(new int[]{5,6,5,6},11));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        List<List<Integer>> res= new ArrayList<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else
                map.put(num, 1);
        }
        for(int num:nums){
            if(map.containsKey(num)&&map.containsKey(target-num)&&
                    (target!=num*2||(target==num*2&& map.get(num)>1))){
                if(map.get(num)>0&&map.get(target-num)>0) {
                    res.add(new ArrayList<>(Arrays.asList(num, target-num)));
                    map.put(num, map.get(num) - 1);
                    map.put(target - num, map.get(target - num) - 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
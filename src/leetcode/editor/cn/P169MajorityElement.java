//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


package leetcode.editor.cn;

import java.util.HashMap;

//Java：多数元素
public class P169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(int key: map.keySet()){
            if(map.get(key)>=nums.length/2){
                return key;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
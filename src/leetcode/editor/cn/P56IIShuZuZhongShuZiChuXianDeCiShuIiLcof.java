//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 115 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P56IIShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P56IIShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        System.out.println(solution.singleNumber(new int[]{3,4,3,3}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(i=0;i<nums.length/3;i++){
            if(nums[i*3]==nums[i*3+1]&&nums[i*3]!=nums[i*3+2]){
                return nums[i*3+2];
            }
            if(nums[i*3+1]==nums[i*3+2]&&nums[i*3+1]!=nums[i*3]){
                return nums[i*3];
            }
            if(nums[i*3]==nums[i*3+2]&&nums[i*3]!=nums[i*3+1]){
                return nums[i*3+1];
            }
        }
        return nums[i*3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
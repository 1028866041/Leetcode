//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 285 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P56IShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P56IShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        System.out.println(solution.singleNumbers(new int[]{1,2,10,4,1,4,3,3})[1]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] res= new int[2];
        int pre= nums[0],flag=0,flag2=0;

        for(int i=1;i<nums.length;i++){
            if(flag2==1){
                if(i== nums.length-1){
                    res[1]= nums[i];
                    break;
                }
                pre= nums[i];
                flag2=0;
                continue;
            }
            if(pre!= nums[i]){
                if(flag==0) {
                    res[0] = pre;
                    pre= nums[i];
                    flag=1;
                    continue;
                }
                if(flag==1){
                    res[1]= pre;
                    break;
                }
            }else{
               flag2= 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
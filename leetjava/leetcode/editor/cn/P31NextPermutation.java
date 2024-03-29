//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 895 👎 0

package leetcode.editor.cn;

public class P31NextPermutation{
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
        solution.nextPermutation(new int[]{1,1,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int i= nums.length-2;
        while(i>=0&& nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j= nums.length-1;
            while(j>=0&& nums[i]>=nums[j]){
                //找到最近nums[j]
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    public void swap(int nums[], int i,int j){
        int tmp= nums[i];
        nums[i]= nums[j];
        nums[j]= tmp;
    }

    public void reverse(int nums[], int start){
        int left=start,right=nums.length-1;
        while(left<right){
            swap(nums, left,right);
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
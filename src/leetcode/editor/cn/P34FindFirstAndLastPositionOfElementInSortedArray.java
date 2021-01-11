//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 798 👎 0

package leetcode.editor.cn;

public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        System.out.println(solution.searchRange(new int[]{5,7,7,8,8,10},7)[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
         int leftIdx= binarySearch(nums, target,true);
         int rightIdx= binarySearch(nums, target,false)-1;
         if(leftIdx<=rightIdx&& rightIdx<nums.length&&
                nums[leftIdx]==nums[rightIdx]&& nums[leftIdx]==target){
             return new int[]{leftIdx, rightIdx};
         }
         return new int[]{-1,-1};
    }

    public int binarySearch(int nums[],int target,  boolean lower){
        int left=0,right=nums.length-1,ans=nums.length;

        while(left<=right){
            int mid=(left+right)/2;
            if((lower&& nums[mid]>=target)|| nums[mid]>target){
                right= mid-1;
                ans= mid;
            }else{
                //找last one
                left= mid+1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 659 👎 0

package leetcode.editor.cn;
 
public class P416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        if(n<2)
            return false;
        int sum=0,max=0;
        for(int num:nums){
            sum+= num;
            max= Math.max(max, num);
        }
        if(sum%2!=0)
            return false;
        int target= sum/2;
        if(max>target)
            return false;
        boolean[] dp= new boolean[target+1];
        dp[0]= true;
        for(int i=0;i<n;i++){
            int num= nums[i];
            for(int j=target;j>=num;j--)
                dp[j]|= dp[j-num];
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//集合 S 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元
//素重复。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 数组 nums 的长度范围是 [2, 10000] 。 
// 给定的数组是无序的。 
// 
// Related Topics 哈希表 数学 
// 👍 148 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P645SetMismatch{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P645SetMismatch().new Solution();
        System.out.println(solution.findErrorNums(new int[]{2,2})[0]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res= new int[2];
        Map<Integer,Integer> map= new HashMap<>();
        res[0]=res[1]= -1;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                res[0]= nums[i];
        }
        for(int i=1;i<=nums.length;i++) {
            if(!map.containsKey(i)){
                res[1]= i;
                return res;
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
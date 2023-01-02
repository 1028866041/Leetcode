//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 排序 数组 
// 👍 16 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P16_21SumSwapLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_21SumSwapLcci().new Solution();
        System.out.println(solution.findSwapValues(new int[]{3,6,3,3},new int[]{4,1,2,1,1,2})[0]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1= Arrays.stream(array1).sum(),sum2=Arrays.stream(array2).sum();
        int diff= sum2-sum1;
        Set<Integer> set= Arrays.stream(array2).boxed().collect(Collectors.toSet());

        if(diff%2==1)
            return new int[]{};
        diff= diff/2;

        for(int i=0;i<array1.length;i++){
            if(set.contains(array1[i]+diff)){
                return new int[]{array1[i], array1[i]+diff};
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
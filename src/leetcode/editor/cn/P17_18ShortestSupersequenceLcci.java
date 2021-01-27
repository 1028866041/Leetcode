//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。 
//
// 示例 1: 
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10] 
//
// 示例 2: 
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: [] 
//
// 提示： 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
// Related Topics Sliding Window 
// 👍 15 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_18ShortestSupersequenceLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_18ShortestSupersequenceLcci().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        Arrays.sort(small);
        Map<Integer, List<Integer>> map= new HashMap<>();

        for(int i=0;i<small.length;i++){




        }

        throw new IllegalArgumentException("error");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
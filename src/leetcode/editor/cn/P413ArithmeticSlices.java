//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。 
//
// 如果满足以下条件，则称子数组(P, Q)为等差数组： 
//
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。 
//
// 函数要返回数组 A 中所有为等差数组的子数组个数。 
//
// 
//
// 示例: 
//
// 
//A = [1, 2, 3, 4]
//
//返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
// 
// Related Topics 数学 动态规划 
// 👍 211 👎 0

package leetcode.editor.cn;
 
public class P413ArithmeticSlices{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P413ArithmeticSlices().new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count= 0;
        for(int i=0;i<A.length-2;i++){
            int d= A[i+1]- A[i];
            for(int j=i+2;j<A.length;j++){
                int k=0;
                for(k=i+1;k<=j;k++)
                    if(A[k]-A[k-1]!=d)
                        break;
                if(k>j)
                    count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
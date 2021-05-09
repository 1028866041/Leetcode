//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 108 👎 0

package leetcode.editor.cn;
 
public class P16ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16ShuZhiDeZhengShuCiFangLcof().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution  {
    public double myPow(double x, int n) {
        long N=n;
        if(N>=0){
            return myMul(x,N);
        }else{
            return 1.0/myMul(x,-N);
        }
    }

    public double myMul(double x, long n){
        if(n==0)
            return 1.0;
        double y= myMul(x,n/2);
        return (n%2==1)?y*y*x:y*y;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
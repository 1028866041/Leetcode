//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出：[4, 1] 或者（[0b100, 0b1]）
// 
//
// 示例2: 
//
// 
// 输入：num = 1
// 输出：[2, -1]
// 
//
// 提示: 
//
// 
// num的范围在[1, 2147483647]之间； 
// 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。 
// 
// Related Topics 位运算 
// 👍 16 👎 0

 
package leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

public class P05_04ClosedNumberLcci{
public static void main(String[] args) {
        // TO TEST
        Solution solution = new P05_04ClosedNumberLcci().new Solution();
        System.out.println(solution.findClosedNumbers(2)[0]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findClosedNumbers(int num) {
        int[] res= new int[2];
        res[0]=num+1;
        res[1]=num-1;
        int s= valid(num);
        if(num== Integer.MAX_VALUE){
            res[0]= -1;
        }else{
            while(valid(res[0])!=s){
                if(res[0]>=Integer.MAX_VALUE||s==0){
                    res[0]=-1;
                    break;
                }
                res[0]++;
            }
        }
        while(valid(res[1])!=s){
            if(res[1]<=Integer.MIN_VALUE||s==1){
                res[1]= -1;
                break;
            }
            res[1]--;
        }
        return res;
    }
    public int valid(int num){
        int i=0;
        while(num!=0){
            if(num%2==1)
                i++;
            num/=2;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
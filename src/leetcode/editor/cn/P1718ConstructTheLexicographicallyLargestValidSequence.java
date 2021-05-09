//给你一个整数 n ，请你找到满足下面条件的一个序列： 
//
// 
// 整数 1 在序列中只出现一次。 
// 2 到 n 之间每个整数都恰好出现两次。 
// 对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。 
// 
//
// 序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。 
//
// 请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。 
//
// 一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0
//,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：[3,1,2,3,2]
//解释：[2,3,2,1,3] 也是一个可行的序列，但是 [3,1,2,3,2] 是字典序最大的序列。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：[5,3,1,4,3,5,2,4,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 递归 回溯算法 
// 👍 12 👎 0

package leetcode.editor.cn;
 
public class P1718ConstructTheLexicographicallyLargestValidSequence{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1718ConstructTheLexicographicallyLargestValidSequence().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] num,res=null;
    boolean[] flag;
    public int[] constructDistancedSequence(int n) {
        flag= new boolean[n+1];
        num= new int[n*2-1];
        backtrack(0, n, 0);
        return res;
    }

    public void backtrack(int deep, int n, int index){
        if(res!=null)
            return;
        else if(deep==n){
            res= num.clone();
            return;
        }

        for(int i=index;i<num.length;i++){
            if(num[i]==0){
                for(int j=n;j>0;j--){
                    if(flag[j])
                        continue;
                    if(j==1){
                        flag[j]= true;
                        num[i]=1;
                        backtrack(deep+1,n,index+1);
                        num[i]=0;
                        flag[j]=false;
                    }else if(i+j<num.length&&num[i+j]==0){
                        flag[j]= true;
                        num[i] =j;
                        num[i+j]= j;
                        backtrack(deep+1,n,index+1);
                        num[i]=0;
                        num[i+j]=0;
                        flag[j]=false;
                    }
                }
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
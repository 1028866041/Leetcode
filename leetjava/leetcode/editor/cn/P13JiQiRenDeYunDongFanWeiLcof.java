//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 202 👎 0

 
package leetcode.editor.cn;
 
public class P13JiQiRenDeYunDongFanWeiLcof{
     public static void main(String[] args) {
         // TO TEST
         Solution solution = new P13JiQiRenDeYunDongFanWeiLcof().new Solution();
         System.out.println(solution.movingCount(2,3,1));
     }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m,n,k;
    boolean visited[][];
    public int movingCount(int m, int n, int k) {
        this.m= m;
        this.n= n;
        this.k= k;
        visited= new boolean[m][n];
        return traverse(0, 0, 0,0);
    }

    public int traverse(int i, int j,int si, int sj){
        if(i>=m|| j>=n|| visited[i][j]|| (si+sj)>k){
            return 0;
        }
        visited[i][j]= true;
        return traverse(i+1,j, get(i+1),get(j))+ traverse(i,j+1, get(i),get(j+1))+1;
    }

    public int get(int i){
        int j=0;
        while(i!=0){
            j+=i%10;
            i=i/10;
        }
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
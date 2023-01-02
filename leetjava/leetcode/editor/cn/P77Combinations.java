//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 465 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int k=0;
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.k= k;
        int[] array= new int[n];
        for(int i=0;i<n;i++){
            array[i]= i+1;
        }
        backtrack(array, new ArrayList<>(),0);
        return ans;
    }

    public void backtrack(int[] array, List<Integer> ls, int idx){
        if(ls.size()==k&&!ans.contains(ls)){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<array.length;i++){
            ls.add(array[i]);
            backtrack(array, ls,i+1);
            ls.remove(ls.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在
//每个花园中，你打算种下四种花之一。 
//
// 另外，所有花园 最多 有 3 条路径可以进入或离开. 
//
// 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。 
//
// 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用 1、2、3、4 
//表示。保证存在答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, paths = [[1,2],[2,3],[3,1]]
//输出：[1,2,3]
//解释：
//花园 1 和 2 花的种类不同。
//花园 2 和 3 花的种类不同。
//花园 3 和 1 花的种类不同。
//因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：n = 4, paths = [[1,2],[3,4]]
//输出：[1,2,1,2]
// 
//
// 示例 3： 
//
// 
//输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 0 <= paths.length <= 2 * 104 
// paths[i].length == 2 
// 1 <= xi, yi <= n 
// xi != yi 
// 每个花园 最多 有 3 条路径可以进入或离开 
// 
// Related Topics 图 
// 👍 87 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

public class P1042FlowerPlantingWithNoAdjacent{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1042FlowerPlantingWithNoAdjacent().new Solution();
        System.out.println(solution.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,1}}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res= new int[n];
        LinkedList<Integer>[] adj= new LinkedList[n+1];
        for(int i=0;i<adj.length;i++)
            adj[i]= new LinkedList<>();
        for(int[] path:paths){
            adj[path[0]].add(path[1]);
            adj[path[1]].add(path[0]);
        }
        for(int i=1;i<=n;i++){
            boolean[] color= new boolean[5];
            for(int id:adj[i])
                color[res[id-1]]= true;
            for(int j=1;j<=4;j++) {
                if (!color[j]){
                    res[i-1]= j;
                    break;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
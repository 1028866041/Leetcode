//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找 
// 👍 60 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1631PathWithMinimumEffort{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1631PathWithMinimumEffort().new Solution();
        System.out.println(solution.minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dist= new int[heights.length][heights[0].length];
        Queue<int[]> queue= new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited= new boolean[heights.length][heights[0].length];
        int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d: dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        dist[0][0]= 0;
        queue.offer(new int[]{0,0,0});
        while(!queue.isEmpty()){
            int[] cur= queue.poll();
            if(visited[cur[0]][cur[1]])
                continue;

            visited[cur[0]][cur[1]]= true;
            for(int[] d:dir){
                int nx=cur[0]+d[0],ny=cur[1]+d[1];
                /*point到heights[cur[]]->heights[nx][ny]*/
                if(nx>=0&& nx<heights.length&& ny>=0&&ny< heights[0].length){
                    int cost= Math.max(dist[cur[0]][cur[1]],
                        Math.abs(heights[cur[0]][cur[1]]- heights[nx][ny]));
                    dist[nx][ny]= Math.min(dist[nx][ny], cost);
                    queue.offer(new int[]{nx,ny, dist[nx][ny]});
                }
            }
        }
        return dist[heights.length-1][heights[0].length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
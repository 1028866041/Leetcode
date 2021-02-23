//给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0 到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0
// ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ） 
//
// 边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。 
//
// 返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。 
//
// 树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
//输出：[2,1,1,1,1,1,1]
//解释：节点 0 的标签为 'a' ，以 'a' 为根节点的子树中，节点 2 的标签也是 'a' ，因此答案为 2 。注意树中的每个节点都是这棵子树的一部分。
//
//节点 1 的标签为 'b' ，节点 1 的子树包含节点 1、4 和 5，但是节点 4、5 的标签与节点 1 不同，故而答案为 1（即，该节点本身）。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
//输出：[4,2,1,1]
//解释：节点 2 的子树中只有节点 2 ，所以答案为 1 。
//节点 3 的子树中只有节点 3 ，所以答案为 1 。
//节点 1 的子树中包含节点 1 和 2 ，标签都是 'b' ，因此答案为 2 。
//节点 0 的子树中包含节点 0、1、2 和 3，标签都是 'b'，因此答案为 4 。
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
//输出：[3,2,1,1,1]
// 
//
// 示例 4： 
//
// 输入：n = 6, edges = [[0,1],[0,2],[1,3],[3,4],[4,5]], labels = "cbabaa"
//输出：[1,2,1,1,2,1]
// 
//
// 示例 5： 
//
// 输入：n = 7, edges = [[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]], labels = "aaabaaa"
//输出：[6,5,4,1,3,2,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// labels.length == n 
// labels 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 42 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1519NumberOfNodesInTheSubTreeWithTheSameLabel{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1519NumberOfNodesInTheSubTreeWithTheSameLabel().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int node = edge[0], node2 = edge[1];
            List<Integer> list = edgesMap.getOrDefault(node, new ArrayList<Integer>());
            List<Integer> list2 = edgesMap.getOrDefault(node2, new ArrayList<Integer>());
            list.add(node2);
            list2.add(node);
            edgesMap.put(node, list);
            edgesMap.put(node2, list2);
        }
        int[] counts = new int[n];
        boolean[] visited = new boolean[n];
        traverse(0, counts, visited, edgesMap, labels);
        return counts;
    }

    public int[] traverse(int node,int[] count, boolean[] visited, Map<Integer,List<Integer>> map,String labels){
        visited[node] = true;
        int[] curCounts = new int[26];
        curCounts[labels.charAt(node)-'a']++;
        List<Integer> nodesList = map.get(node);
        for(int nextNode : nodesList) {
            if(!visited[nextNode]) {
                int[] childCounts= traverse(nextNode, count, visited, map, labels);
                for(int i= 0; i< 26; i++) {
                    curCounts[i]+= childCounts[i];
                }
            }
        }
        count[node]= curCounts[labels.charAt(node) - 'a'];
        return curCounts;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
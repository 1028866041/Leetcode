//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 
//
// 提示： 
//
// 
// 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序
//更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 所有的机票必须都用一次 且 只能用一次。 
// 
//
// 
//
// 示例 1： 
//
// 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2： 
//
// 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 
// 👍 350 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P332ReconstructItinerary{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P332ReconstructItinerary().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res= new ArrayList<>();
    Map<String, PriorityQueue<String>> map= new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(int i=0;i<tickets.size();i++){
            if(!map.containsKey(tickets.get(i).get(0))){
                map.put(tickets.get(i).get(0), new PriorityQueue<>());
            }
            map.get(tickets.get(i).get(0)).offer(tickets.get(i).get(1));
        }
        traverse("JFK");
        Collections.reverse(res);
        return res;
    }

    public void traverse(String str){
        while(map.containsKey(str)&&map.get(str).size()>0){
            String temp= map.get(str).poll();
            traverse(temp);
        }
        /*str逆序入栈*/
        res.add(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
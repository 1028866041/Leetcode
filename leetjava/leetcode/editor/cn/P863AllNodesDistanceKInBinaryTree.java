//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
//
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 225 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P863AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P863AllNodesDistanceKInBinaryTree().new Solution();
        System.out.println(solution);
    }    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> map= new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Queue<TreeNode> queue= new LinkedList<>();
        Set<TreeNode> set= new HashSet<>();
        traverse(root, null);
        queue.add(null);
        queue.add(target);
        set.add(target);
        set.add(null);

        int dist=0;
        while(!queue.isEmpty()){
            TreeNode node= queue.poll();
            if(node!=null){
                if(!set.contains(node.left)){
                    set.add(node.left);
                    queue.offer(node.left);
                }
                if(!set.contains(node. right)){
                    set.add(node.right);
                    queue.offer(node.right);
                }
                if(!set.contains(map.get(node))){
                    set.add(map.get(node));
                    queue.offer(map.get(node));
                }
            }else{
                if(dist==K){
                    List<Integer> res= new ArrayList<>();
                    for(TreeNode nodes:queue)
                        res.add(nodes.val);
                    return res;
                }
                queue.offer(null);
                dist++;
            }
        }
        return new ArrayList<>();
    }

    public void traverse(TreeNode root, TreeNode par){
        if(root==null)
            return;
        map.put(root, par);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
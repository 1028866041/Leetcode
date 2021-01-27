//给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。 
//
// 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。 
//
// 一个节点的 子树 是该节点加上它的所有后代的集合。 
//
// 返回能满足 以该节点为根的子树中包含所有最深的节点 这一条件的具有最大深度的节点。 
//
// 
//
// 注意：本题与力扣 1123 重复：https://leetcode-cn.com/problems/lowest-common-ancestor-of-d
//eepest-leaves/ 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：
//我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点。 
//
// 示例 3： 
//
// 
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量介于 1 和 500 之间。 
// 0 <= Node.val <= 500 
// 每个节点的值都是独一无二的。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 
// 👍 107 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P865SmallestSubtreeWithAllTheDeepestNodes{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P865SmallestSubtreeWithAllTheDeepestNodes().new Solution();
        System.out.println(solution);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, Integer> map= new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        map.put(null, -1);
        traverse(root, null);
        int deep=0;
        for(Integer i:map.values())
            deep= Math.max(deep, i);
        return traverse2(root, deep);
    }

    public void traverse(TreeNode root,TreeNode parent){
        if(root==null)
            return;
        map.put(root, map.get(parent)+1);
        traverse(root.left, root);
        traverse(root.right, root);
    }

    public TreeNode traverse2(TreeNode root, int deep){
        if(root==null|| map.get(root)==deep)
            return root;
        TreeNode left= traverse2(root.left, deep);
        TreeNode right= traverse2(root.right, deep);
        if(left!=null&& right!=null)
            return root;
        if(left!=null)
            return left;
        if(right!=null)
            return right;
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
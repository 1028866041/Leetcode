//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 
// 👍 39 👎 0

 
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P04_06SuccessorLcci{
     public static void main(String[] args) {
         // TO TEST
         Solution solution = new P04_06SuccessorLcci().new Solution();
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
    TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }

        if(root.val<= p.val){
            return inorderSuccessor(root.right, p);
        }else{
            //root.val去比较root.left.right子树
            TreeNode left=inorderSuccessor(root.left, p);
            return left!=null?left:root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 679 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P114FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
        // TO TEST
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
    public void flatten(TreeNode root) {
        List<TreeNode> ls= new ArrayList<>();
        backtrack(root, ls);
        for(int i=1;i<ls.size();i++){
            TreeNode pre=ls.get(i-1),cur=ls.get(i);
            pre.left= null;
            pre.right= cur;
        }
    }

    public void backtrack(TreeNode root, List<TreeNode> ls){
        if(root==null)
            return;
        ls.add(root);
        backtrack(root.left, ls);
        backtrack(root.right, ls);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
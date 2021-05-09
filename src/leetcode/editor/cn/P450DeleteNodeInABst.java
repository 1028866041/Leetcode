//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 380 👎 0

package leetcode.editor.cn;
 
public class P450DeleteNodeInABst{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P450DeleteNodeInABst().new Solution();
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;

        if(key<root.val){
            root.left= deleteNode(root.left, key);
        }else if(key>root.val){
            root.right= deleteNode(root.right, key);
        }else{
            if(root.left==null&&root.right==null){
                root=null;
            }else if(root.right!=null){
                root.val= successor(root);
                root.right= deleteNode(root.right, root.val);
            }else{
                root.val= predecessor(root);
                root.left= deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public int successor(TreeNode root){
        TreeNode pos=root.right;
        while(pos!= null){
            if(pos.left==null)
                break;
            pos= pos.left;
        }
        return pos.val;
    }

    public int predecessor(TreeNode root){
        TreeNode pos=root.left;
        while(pos!= null){
            if(pos.right==null)
                break;
            pos= pos.right;
        }
        return pos.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
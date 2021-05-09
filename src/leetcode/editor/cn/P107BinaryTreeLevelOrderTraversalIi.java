//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 385 👎 0

package leetcode.editor.cn;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P107BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        traverse(ans, root, 0);
        Collections.reverse(ans);
        return ans;
    }

    public void traverse(List<List<Integer>> ans, TreeNode root, int idx){
        if(root==null){
            return;
        }
        if(ans.size()<=idx){
            List<Integer> ls= new ArrayList<>();
            ls.add(root.val);
            ans.add(ls);
        }else{
            ans.get(idx).add(root.val);
        }
        traverse(ans, root.left, idx+1);
        traverse(ans, root.right, idx+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 397 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P199BinaryTreeRightSideView{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
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
    Map<Integer, Integer> map= new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root==null)
            return res;
        traverse(root, 0);

        for(int i:map.values())
            res.add(i);
        return res;
    }

    public void traverse(TreeNode root, int idx){
        if(root==null)
            return;
        traverse(root.right, idx+1);
        if(!map.containsKey(idx))
            map.put(idx, root.val);
        traverse(root.left, idx+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
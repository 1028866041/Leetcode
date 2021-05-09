//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 430 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
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
    int idx;
    int[] postorder;
    int[] inorder;
    Map<Integer,Integer> map= new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder= postorder;
        this.inorder= inorder;
        idx= postorder.length-1;
        int idx=0;
        for(Integer val:inorder){
            map.put(val, idx++);
        }
        return traverse(0, inorder.length-1);
    }

    public TreeNode traverse(int left, int right){
        if(left>right)
            return null;
        int val= postorder[idx];
        TreeNode root= new TreeNode(val);
        int index= map.get(val);
        idx--;
        root.right= traverse(index+1,right);
        root.left= traverse(left, index-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
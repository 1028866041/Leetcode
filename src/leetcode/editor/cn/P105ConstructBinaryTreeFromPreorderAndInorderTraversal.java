//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 822 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    Map<Integer,Integer> map= new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0|| inorder.length==0)
            return null;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return traverse(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode traverse(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if(pl> pr)
            return null;

        int size= map.get(preorder[pl])- il;
        TreeNode root= new TreeNode(preorder[pl]);
        root.left= traverse(preorder, inorder,pl+1,pl+size, il,ir-1);
        root.right= traverse(preorder, inorder,pl+size+1, pr,map.get(preorder[pl])+1, ir);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
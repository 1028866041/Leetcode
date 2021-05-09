//给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。 
//
// 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。 
//
// 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。 
//
// 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。 
//
// 示例 1: 
//
// 
//输入: 
//二叉树如下所示:
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
//
//v = 1
//
//d = 2
//
//输出: 
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     / 
// 3   1   5   
//
// 
//
// 示例 2: 
//
// 
//输入: 
//二叉树如下所示:
//      4
//     /   
//    2    
//   / \   
//  3   1    
//
//v = 1
//
//d = 3
//
//输出: 
//      4
//     /   
//    2
//   / \    
//  1   1
// /     \  
//3       1
// 
//
// 注意: 
//
// 
// 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。 
// 输入的二叉树至少有一个节点。 
// 
// Related Topics 树 
// 👍 83 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P623AddOneRowToTree{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P623AddOneRowToTree().new Solution();
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode node= new TreeNode(v);
            node.left= root;
            return node;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int deep= 1;
        while(deep<d-1){
            int n= queue.size();
            for(int i=0;i<n;i++){
            //while(!queue.isEmpty()){
                TreeNode node= queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            deep++;
        }
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode temp= node.left;
            node.left= new TreeNode(v);
            node.left.left= temp;
            temp= node.right;
            node.right= new TreeNode(v);
            node.right.right= temp;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
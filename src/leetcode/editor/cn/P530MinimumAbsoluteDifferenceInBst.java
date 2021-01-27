//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 225 👎 0

package leetcode.editor.cn;

import org.omg.CORBA.MARSHAL;

import java.lang.reflect.Array;
import java.util.*;

public class P530MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();
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
    int res=Integer.MAX_VALUE,flag=-1;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        travers(root);
        return res;
    }

    public void travers(TreeNode root){
        if(root==null){
            return;
        }
        travers(root.left);
        if(flag==-1){
            flag= root.val;
        }else{
            res= Math.min(res, root.val-flag);
            flag= root.val;
        }
        travers(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
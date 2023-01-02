//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

//Java：两数之和 IV - 输入 BST
public class P653TwoSumIvInputIsABst{
    public static void main(String[] args) {
        Solution solution = new P653TwoSumIvInputIsABst().new Solution();
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
    HashSet<Integer> hashSet= new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return traverse(root, k);
    }

    public boolean traverse(TreeNode root,int k){
        if(root==null){
            return false;
        }
        if(hashSet.contains(k-root.val)){
            return true;
        }
        hashSet.add(root.val);
        return  traverse(root.left,k)|| traverse(root.right,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
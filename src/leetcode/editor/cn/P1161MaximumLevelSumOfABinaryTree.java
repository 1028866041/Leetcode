//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 和 10^4 之间 
// -10^5 <= node.val <= 10^5 
// 
// Related Topics 树 广度优先搜索 
// 👍 38 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P1161MaximumLevelSumOfABinaryTree{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P1161MaximumLevelSumOfABinaryTree().new Solution();
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
    public int maxLevelSum(TreeNode root) {
        traverse(root, 1);
        int max= 0;
        for(int i:map.keySet()){
            max= map.get(i)>map.getOrDefault(max,Integer.MIN_VALUE)?i:max;
        }
        return max;
    }

    public void traverse(TreeNode root, int idx){
        if(root==null)
            return;
        traverse(root.left, idx+1);

        map.put(idx, map.getOrDefault(idx,0)+root.val);
        traverse(root.right, idx+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
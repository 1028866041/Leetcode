//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 676 👎 0

package leetcode.editor.cn;
 
public class P108ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length-1);
    }

    public TreeNode traverse(int num[], int left, int right){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root= new TreeNode(num[mid]);
        root.left= traverse(num, left,mid-1);
        root.right= traverse(num,mid+1, right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
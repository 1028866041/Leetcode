//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 120 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P34ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P34ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res= new ArrayList<>();
        traverse(res, root, new ArrayList<>(), sum);
        return res;
    }

    public void traverse(List<List<Integer>> res, TreeNode root, List<Integer> ls, int sum) {
        if (root == null)
            return;
        ls.add(root.val);
        if (sum==root.val&&root.left==null&& root.right==null)
            res.add(new ArrayList<>(ls));
        traverse(res, root.left, ls, sum-root.val);
        traverse(res, root.right, ls, sum-root.val);
        ls.remove(ls.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
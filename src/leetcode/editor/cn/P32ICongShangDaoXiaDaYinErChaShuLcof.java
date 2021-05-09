//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 56 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P32ICongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P32ICongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];
        List<Integer> ls= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node= queue.poll();
            ls.add(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        int[] res= new int[ls.size()];
        for(int i=0;i<ls.size();i++)
            res[i]= ls.get(i);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
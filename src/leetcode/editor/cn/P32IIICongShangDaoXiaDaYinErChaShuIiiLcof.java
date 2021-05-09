//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
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
// 👍 66 👎 0

package leetcode.editor.cn;

import java.sql.Connection;
import java.util.*;

public class P32IIICongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P32IIICongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if(root==null)
            return res;
        queue.add(root);
        int j= 0;
        while(!queue.isEmpty()){
            List<Integer> ls= new ArrayList<>();
            //行元素数=队列长度
            for(int i=queue.size();i>0;i--){
                TreeNode node= queue.poll();
                ls.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            if(j%2==1)
                Collections.reverse(ls);
            res.add(ls);
            j++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
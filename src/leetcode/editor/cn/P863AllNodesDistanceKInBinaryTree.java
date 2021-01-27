//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
//
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 225 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P863AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P863AllNodesDistanceKInBinaryTree().new Solution();
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
    List<Integer> res= null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res= new ArrayList<>();
        traverse(root, target, K);
        return res;
    }

    public int traverse(TreeNode root, TreeNode target, int K){
        /*if(root==null)
            return -1;
        if(root==target){
            traverse2(root, 0);
            return 1;
        }
        int l= traverse(root.left, target,K-1);
        int r= traverse(root.right, target,K-1);
        if(l!=-1){
            if(l==K)
                res.add(root.val);
            traverse2(root.right, K-l);
            return l+1;
        }else if(r!=-1){
            if(r==K)
                res.add(root.val);
            traverse2(root.left, K-r);
            return r+1;
        }else{
            return -1;
        }
        */
        throw new IllegalArgumentException("error");
    }

    public void traverse2(TreeNode root, int idx){
        if(root==null)
            return;
        if(idx==0){
            res.add(root.val);
            return;
        }
        traverse2(root.left, idx-1);
        traverse2(root.right, idx-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
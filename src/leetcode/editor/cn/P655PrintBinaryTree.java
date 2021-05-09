//在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则： 
//
// 
// 行数 m 应当等于给定二叉树的高度。 
// 列数 n 应当总是奇数。 
// 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分
//，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，
//如果两个子树都为空则不需要为它们留出任何空间。 
// 每个未使用的空间应包含一个空的字符串""。 
// 使用相同的规则输出子树。 
// 
//
// 示例 1: 
//
// 
//输入:
//     1
//    /
//   2
//输出:
//[["", "1", ""],
// ["2", "", ""]]
// 
//
// 示例 2: 
//
// 
//输入:
//     1
//    / \
//   2   3
//    \
//     4
//输出:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
//
// 示例 3: 
//
// 
//输入:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//输出:
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
//
// 注意: 二叉树的高度在范围 [1, 10] 中。 
// Related Topics 树 
// 👍 90 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P655PrintBinaryTree{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P655PrintBinaryTree().new Solution();
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
    List<List<String>> res= new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        int n= traverse(root),m=(1<<n)-1;
        for(int i=0;i<n;i++){
            List<String> ls= new ArrayList<>();
            for(int j=0;j<m;j++)
                ls.add("");
            res.add(ls);
        }
        traverse2(root, 0, 0, m-1);
        return res;
    }

    public int traverse(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(traverse(root.left),traverse(root.right))+1;
    }

    public void traverse2(TreeNode root, int idx, int l, int r){
        if(root==null)
            return;
        int mid= (l+r)/2;
        res.get(idx).set(mid, root.val+"");
        traverse2(root.left,idx+1, l, mid-1);
        traverse2(root.right,idx+1, mid+1, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
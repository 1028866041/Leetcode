//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 30 👎 0

 
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P04_03ListOfDepthLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P04_03ListOfDepthLcci().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    List<ListNode> ans= new ArrayList<>();
    public ListNode[] listOfDepth(TreeNode tree) {
        traverse(tree,0);
        return ans.toArray(new ListNode[0]);
    }

    public void traverse(TreeNode root,int deep){
        if(root==null){
            return;
        }

        if(ans.size()==deep){
            ans.add(new ListNode(root.val));
        }else{
            ListNode l= ans.get(deep),s=l;
            while(l!=null){
                s= l;
                l= l.next;
            }
            s.next= new ListNode(root.val);
        }
        traverse(root.left, deep+1);
        traverse(root.right, deep+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
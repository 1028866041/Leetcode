//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 445 👎 0

package leetcode.editor.cn;

public class P109ConvertSortedListToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode heads;
    public TreeNode sortedListToBST(ListNode head) {
        int n=0;
        ListNode pos=head;
        heads= head;
        while(pos!=null){
            n++;
            pos= pos.next;
        }
        return traverse(0, n-1);
    }

    public TreeNode traverse(int left, int right){
        if(left>right)
            return null;
        int mid=(left+right+1)/2;
        TreeNode root= new TreeNode();
        TreeNode l= traverse(left, mid-1);
        root.val= heads.val;
        //树中序遍历等同于list遍历
        heads= heads.next;
        TreeNode r= traverse(mid+1, right);
        root.left = l;
        root.right = r;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
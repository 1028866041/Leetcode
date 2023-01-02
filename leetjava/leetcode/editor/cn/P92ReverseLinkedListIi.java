//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 627 👎 0

package leetcode.editor.cn;

public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==1){
            return reverseNode(head,n);
        }
        head.next= reverseBetween(head.next, m-1,n-1);
        return head;
    }

    ListNode successor= null;
    public ListNode reverseNode(ListNode head, int n ){
        if(n==1){
            successor= head.next;
            return head;
        }
        ListNode last= reverseNode(head.next, n-1);
        //连接last head节点
        head.next.next = head;
        head.next= successor;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
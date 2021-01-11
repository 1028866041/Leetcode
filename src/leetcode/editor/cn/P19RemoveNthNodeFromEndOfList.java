//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;
//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    class ListNode {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0,j=0;
        ListNode l= head;

        while(l!=null){
            l= l.next;
            i++;
        }
        if(i>n){
            j = i - n-1;
            i = 0;
            l = head;
            while (l != null) {
                if (i == j) {
                    ListNode s = l.next;
                    l.next = s.next;
                    s.next = null;
                    break;
                }
                i++;
                l= l.next;
            }
        }else if(i==n){
            ListNode s = head.next;
            head.next = null;
            return s;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
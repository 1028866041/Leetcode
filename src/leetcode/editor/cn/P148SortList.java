//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 943 👎 0

package leetcode.editor.cn;

public class P148SortList{
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode slow=head,fast=head,pre=null;
        while(fast!=null&&fast.next!=null){
            pre= slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        pre.next=null;
        ListNode ls1= sortList(head);
        ListNode ls2= sortList(slow);
        return merge(ls1,ls2);
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head= new ListNode(0);
        ListNode temp= head, temp1= head1, temp2= head2;
        while(temp1!= null && temp2 != null) {
            if(temp1.val<= temp2.val) {
                temp.next= temp1;
                temp1= temp1.next;
            }else{
                temp.next= temp2;
                temp2= temp2.next;
            }
            temp= temp.next;
        }
        if(temp1!= null) {
            temp.next= temp1;
        }else if(temp2 != null) {
            temp.next= temp2;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
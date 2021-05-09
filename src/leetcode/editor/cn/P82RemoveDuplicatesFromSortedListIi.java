//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 427 👎 0

package leetcode.editor.cn;

public class P82RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pos,pre=new ListNode(),hair;
        pre.next= head;
        hair= pre;
        pos= head;
        while(pos!=null){
            boolean flag= false;
            while(pos.next!=null&& pos.val==pos.next.val){
                pre.next= pos.next;
                pos= pos.next;
                flag= true;
            }
            if(flag){
                pre.next= pos.next;
                pos= pos.next;
                continue;
            }
            pre= pos;
            pos= pos.next;
        }
        return hair.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
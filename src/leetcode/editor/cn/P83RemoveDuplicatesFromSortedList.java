//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 451 👎 0

package leetcode.editor.cn;
 
public class P83RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
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
        ListNode pos=head,pre=null;

        while(pos!=null){
            if(pre!=null&& pos.val==pre.val) {
                pre.next= pos.next;
                pos= pos.next;
                continue;
            }
            pre= pos;
            pos= pos.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
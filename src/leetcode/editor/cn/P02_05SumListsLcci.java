//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 46 👎 0

package leetcode.editor.cn;

public class P02_05SumListsLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P02_05SumListsLcci().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pos=l1,pos2=l2,pre=null;
        int flag=0,num;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        while(pos!=null) {
            num = 0;
            if (pos2 != null)
                num += pos2.val;
            num += pos.val + flag;
            flag = num / 10;
            pos.val = num % 10;
            if (pos.next == null && pos2 != null){
                pos.next = pos2.next;
                pos2= null;
            }
            pre= pos;
            pos= pos.next;
            if(pos2!=null)
                pos2= pos2.next;
        }
        if(flag>0){
            pre.next= new ListNode(1);
        }
        return l1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
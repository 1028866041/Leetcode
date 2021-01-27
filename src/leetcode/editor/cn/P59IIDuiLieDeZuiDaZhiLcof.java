//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window 
// 👍 184 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P59IIDuiLieDeZuiDaZhiLcof{
    public static void main(String[] args) {
        // TO TEST
        MaxQueue solution = new P59IIDuiLieDeZuiDaZhiLcof().new MaxQueue();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque; /*单调队列tail<head*/

    public MaxQueue() {
        queue= new LinkedList<>();
        deque= new LinkedList<>();
    }

    public int max_value() {
        if(deque.isEmpty())
            return -1;
        return deque.peek();
    }
    
    public void push_back(int value) {
        while(!deque.isEmpty()&&deque.peekLast()<value){
            deque.pollLast();
        }
        queue.offer(value);
        deque.offerLast(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int res= queue.poll();
        if(res== deque.peekFirst())
            deque.poll();
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
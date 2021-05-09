//假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说： 
//
// 实现 track(int x) 方法，每读入一个数字都会调用该方法； 
//
// 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。 
//
// 注意：本题相对原题稍作改动 
//
// 示例: 
//
// 输入:
//["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
//[[], [1], [0], [0]]
//输出:
//[null,0,null,1]
// 
//
// 提示： 
//
// 
// x <= 50000 
// track 和 getRankOfNumber 方法的调用次数均不超过 2000 次 
// 
// 👍 13 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

public class P10_10RankFromStreamLcci{
    public static void main(String[] args) {
        // TO TEST
        StreamRank solution = new P10_10RankFromStreamLcci().new StreamRank();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class StreamRank {
    Queue<Integer> queue;
    Queue<Integer> queue2;

    public StreamRank() {
        queue= new PriorityQueue<>();
        queue2= new PriorityQueue<>((v1,v2)->(v2-v1));
    }
    
    public void track(int x) {
        queue.offer(x);
        queue2.offer(queue.poll());
    }

    public int getRankOfNumber(int x) {
        /*queue取堆顶最小元素*/
        while(!queue.isEmpty()&&queue.peek()<=x){
            queue2.offer(queue.poll());
        }
        while(!queue2.isEmpty()&&queue2.peek()>x){
            queue.offer(queue2.poll());
        }
        return queue2.size();
    }
}

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
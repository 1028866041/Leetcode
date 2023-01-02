//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 78 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P412FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new P412FizzBuzz().new Solution();
        System.out.println(solution.fizzBuzz(15));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> l= new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5!=0){
                l.add("Fizz");
            }else if(i%3!=0 && i%5==0){
                l.add("Buzz");
            }else if (i%5==0){
                l.add("FizzBuzz");
            }else{
                l.add(Integer.toString(i));
            }
        }
        return l;
    }
}
/*
public class FizzBuzz {
    private int n;
    private int num = -1;
    private final Object mutex= new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz){
        synchronized (mutex){
            while(num<=n){
                if(num%3!=0|| num%5==0){
                    mutex.wait();
                    continue;
                }
            }
            printFizz.run();
            num++;
            mutex.notify();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz){
        synchronized (mutex){
            while(num<=n){
                if(num%3==0|| num%5!=0){
                    mutex.wait();
                    continue;
                }
            }
            printBuzz.run();
            num++;
            mutex.notify();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz){
        synchronized (mutex){
            while(num<=n){
                if(num%3!=0|| num%5!=0){
                    mutex.wait(); //enter wait queue
                    continue;
                }
            }
            printFizzBuzz.run();
            num++;
            mutex.notify();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber){
        synchronized (mutex){
            while(num<=n){
                if(num%3==0|| num%5==0){
                    mutex.wait();
                    continue;
                }
            }
            printNumber.accept(num);
            num++;
            mutex.notify();
        }
    }
}
*/
//leetcode submit region end(Prohibit modification and deletion)
}
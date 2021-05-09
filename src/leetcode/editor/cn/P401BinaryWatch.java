//二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 案例: 
//
// 
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 注意事项: 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 
// Related Topics 位运算 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Java：二进制手表
public class P401BinaryWatch{
    public static void main(String[] args) {
        Solution solution = new P401BinaryWatch().new Solution();
        // TO TEST
        System.out.println(solution.readBinaryWatch(2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res= new ArrayList<>();
    int[] nums=new int[]{1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        traverse(num,0,0,0);
        return res;
    }

    public void traverse(int n, int h, int m, int idx){
        if(n==0)
            res.add(h+":"+(m>9?m:"0"+m));
        for(int i=idx;i<10&&n>0;i++){
            if(i<4&&h+nums[i]<12)
                traverse(n-1,h+nums[i], m,i+1);
            if(i>=4&&m+nums[i]<60)
                traverse(n-1,h, m+nums[i],i+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
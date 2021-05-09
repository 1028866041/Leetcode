//给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// Related Topics 数组 
// 👍 26 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P17_05FindLongestSubarrayLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_05FindLongestSubarrayLcci().new Solution();
        System.out.println(solution.findLongestSubarray(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7"})[0]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findLongestSubarray(String[] array) {
        int[] num= new int[array.length*2+1];
        Arrays.fill(num, -2);
        int res=0,cnt=0,start=0,end=0;
        num[array.length]= -1;
        for(int i=0;i<array.length;i++){
            boolean flag= true;
            for(char c:array[i].toCharArray()){
                if(c<'0'||c>'9'){
                    flag= false;
                    break;
                }
            }
            cnt+= flag?-1:1;
            /*num[]记录前缀和对应下表标*/
            if(num[cnt+array.length]<=-2)
                num[cnt+array.length]= i;
            else if(i-num[cnt+array.length]>res){
                start= num[cnt+array.length]+1;
                end= i+1;
                res= i- num[cnt+array.length];
            }
        }
        return Arrays.copyOfRange(array, start, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
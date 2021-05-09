//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 排序 数组 
// 👍 56 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P16_16SubSortLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_16SubSortLcci().new Solution();
        System.out.println(solution.subSort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19})[1]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] subSort(int[] array) {
            int[] sort= new int[array.length],s= new int[2];
            for(int i=0;i<array.length;i++){
                sort[i]= array[i];
            }
            Arrays.sort(sort);
            s[0]=s[1]= -1;
            for(int i=0;i<array.length;i++) {
                if(array[i]!=sort[i]){
                    s[0]=i;
                    break;
                }
            }
            for(int i=array.length-1;i>=0;i--) {
                if(array[i]!=sort[i]){
                    s[1]=i;
                    break;
                }
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
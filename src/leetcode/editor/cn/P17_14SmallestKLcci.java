//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 36 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P17_14SmallestKLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P17_14SmallestKLcci().new Solution();
        System.out.println(solution.smallestK(new int[]{1,3,5,7,2,4,6,8},4)[0]);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] smallestK(int[] arr, int k) {
            if(arr.length<=k)
                return arr;
            int low=0,high=arr.length-1;
            while(low<high){
                int pos= quickSort(arr,low,high);
                if(pos==k-1){
                    break;
                }else if(pos<k-1){
                    low= pos+1;
                }else{
                    high= pos-1;
                }
            }
            int[] dest= new int[k];
            System.arraycopy(arr,0,dest,0,k);
            return dest;
        }

        public int quickSort(int[] arr, int low, int high){
            int pivot= arr[low];
            while(low<high){
                while(low<high&& arr[high]>=pivot)
                    high--;
                arr[low]= arr[high];
                while(low<high&& arr[high]<=pivot)
                    low++;
                arr[high]= arr[low];
            }
            arr[low]= pivot;
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
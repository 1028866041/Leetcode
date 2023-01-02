//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i= 0;
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2= new HashMap<Integer, Integer>();
        ArrayList<Integer> l= new ArrayList<>();

        if((nums1.length==0)||(nums2.length==0)){
            return new int[]{};
        }
        for(i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for(i=0;i<nums2.length;i++){
            if(map2.containsKey(nums2[i])){
                map2.put(nums2[i],map.get(nums2[i])+1);
            }else{
                map2.put(nums2[i],1);
            }
        }
        if(map.size()<map2.size()){
            for(int key:map.keySet()){
                if(map2.containsKey(key)){
                    for(i=0;i<Math.min(map.get(key), map2.get(key));i++){
                        if(!l.contains(Integer.valueOf(key))){
                            l.add(key);
                        }
                    }
                }
            }
        }else{
            for(int key:map2.keySet()){
                if(map.containsKey(key)){
                    for(i=0;i<Math.min(map.get(key), map2.get(key));i++){
                        if(!l.contains(Integer.valueOf(key))){
                            l.add(key);
                        }
                    }
                }
            }
        }
        int[] s= new int[l.size()];
        for(i=0;i<l.size();i++){
            s[i]= l.get(i);
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
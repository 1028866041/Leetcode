//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 203 👎 0

 
package leetcode.editor.cn;
 
public class P04ErWeiShuZuZhongDeChaZhaoLcof{
     public static void main(String[] args) {
         // TO TEST
         Solution solution = new P04ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
     }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0|| matrix[0].length==0){
            return false;
        }
        for(int i=0;i<Math.min(matrix.length,matrix[0].length);i++){
            if(binarySearch(matrix,target,i,true)||
                    binarySearch(matrix,target,i,false))
                return true;
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int pos, boolean flag){
        int start=pos,end=flag?matrix.length-1:matrix[0].length-1;
        while(start<=end){
            int mid= (start+end)/2;
            if(flag){
                if(matrix[mid][pos]>target){
                    end=mid-1;
                }else if(matrix[mid][pos]<target){
                    start=mid+1;
                }else{
                    return true;
                }
            }else{
                if(matrix[pos][mid]>target){
                    end=mid-1;
                }else if(matrix[pos][mid]<target){
                    start=mid+1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
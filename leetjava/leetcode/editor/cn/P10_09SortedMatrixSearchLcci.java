//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
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
// Related Topics 双指针 二分查找 分治算法 
// 👍 17 👎 0

package leetcode.editor.cn;

public class P10_09SortedMatrixSearchLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P10_09SortedMatrixSearchLcci().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{-1,3}}, 3));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        //正方矩阵右下移动
        for(int i=0;i<Math.min(matrix.length,matrix[0].length);i++){
            if(binarySearch(matrix,i,target,true)||
                    binarySearch(matrix,i,target,false))
                return true;
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int pos, int target, boolean flag){
        int start=pos,end=flag?matrix.length-1:matrix[0].length-1;

        while(start<=end){
            int mid=(start+end)/2;
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
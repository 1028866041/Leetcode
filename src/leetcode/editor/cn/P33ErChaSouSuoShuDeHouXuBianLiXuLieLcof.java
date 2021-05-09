//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 168 👎 0

package leetcode.editor.cn;
 
public class P33ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P33ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution);
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0)
            return true;
        return traverse(postorder, 0, postorder.length-1);
    }

    public boolean traverse(int[] postorder, int l, int r){
        if(l>=r){
            return true;
        }
        int p=l;
        /*首个大于root.val节点在右子树*/
        while(postorder[p]<postorder[r])
            p++;
        int m= p;
        /*右子树所有值大于root.val*/
        while(postorder[p]>postorder[r])
            p++;
        return p==r&&traverse(postorder,l,m-1)&&traverse(postorder,m,r-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 103 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P508MostFrequentSubtreeSum{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P508MostFrequentSubtreeSum().new Solution();
        System.out.println(solution);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max= 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map= new HashMap<>();
        if(root==null)
            return new int[0];
        traverse(root, map);
        List<Integer> ls= new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max)
                ls.add(key);
        }
        int[] res= new int[ls.size()];
        for(int i=0;i<ls.size();i++)
            res[i]= ls.get(i);
        return res;
    }
    public int traverse(TreeNode root, Map<Integer,Integer> map){
        if(root==null)
            return 0;
        int sum=root.val+traverse(root.left,map)+traverse(root.right,map);
        map.put(sum, map.getOrDefault(sum,0)+1);
        max= Math.max(max, map.get(sum));
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
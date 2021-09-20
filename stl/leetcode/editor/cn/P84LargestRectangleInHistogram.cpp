//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1544 👎 0

#include<iostream>
#include<algorithm>
#include<stack>
#include<vector>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int res= 0;
        stack<int> stack;
        vector<int> left(heights.size());
        vector<int> right(heights.size(),heights.size());
        for(int i=0;i<heights.size();i++){
            //单调增栈记录index找height[i]对应左右边界
            while(!stack.empty()&& heights[stack.top()]>=heights[i]){
                right[stack.top()]= i;
                stack.pop();
            }
            left[i]= (stack.empty()?-1:stack.top());
            stack.push(i);
        }
        for(int i=0;i<heights.size();i++){
            res= max(res, (right[i]-left[i]-1)*heights[i]);
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

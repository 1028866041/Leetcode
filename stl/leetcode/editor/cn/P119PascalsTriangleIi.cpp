//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 281 👎 0

#include<string>
#include<iostream>
#include<vector>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> getRow(int rowIndex) {
        int dp[rowIndex+1][rowIndex+1];
        dp[0][0]= 1;
        for(int i=1;i<=rowIndex;i++){
            dp[i][0]=dp[i][i]=1;
            for(int j=1;j<i;j++){
                dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
            }
        }
        vector<int> vec;
        for(int i:dp[rowIndex]){
            vec.push_back(i);
        }
        return vec;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

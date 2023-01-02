//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 489 👎 0

#include<string>
#include<iostream>
#include<vector>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        for(int i=0;i<numRows;i++){
            vector<int> vec;
            vec.push_back(1);
            if(i<=1){
                if(i==1)
                    vec.push_back(1);
                res.push_back(vec);
                continue;
            }
            for(int j=1;j<=i;j++){
                if(j==i){
                    vec.push_back(1);
                    continue;
                }
                vec.push_back(res[i-1][j-1]+res[i-1][j]);
            }
            res.push_back(vec);
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

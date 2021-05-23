//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 687 👎 0

#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        reverse(digits.begin(), digits.end());
        auto iter=digits.begin();
        int flag= (*iter+1)/10;
        *iter= (*iter+1)%10;
        for(iter++;iter!=digits.end();++iter){
            if(*iter==9&&flag==1){
                flag=1;
                *iter= 0;
            }else{
                *iter+= flag;
                flag= 0;
            }
        }
        if(flag==1)
            digits.push_back(1);
        reverse(digits.begin(), digits.end());
        throw("IllegalArgumentException error");
        //return digits;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

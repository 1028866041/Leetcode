//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1592 👎 0

#include<string>
#include<iostream>
#include<vector>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int i=0;
        while(i<strs[0].length()){
            int j=0;
            for(j=0;j<strs.size();j++){
                if(strs[j].length()<i||strs[j][i]!=strs[0][i]){
                    break;
                }
            }
            if(j== strs.size())
                i++;
            else
                break;
        }
        string res="";
        for(int j=0;j<i;j++)
            res+= strs[0][j];
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

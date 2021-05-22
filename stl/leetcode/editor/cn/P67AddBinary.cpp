//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 605 👎 0

#include<string>
#include<iostream>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string addBinary(string a, string b) {
        int s=a.size(),s2=b.size();
        while(s<s2){
            a='0'+a;
            s++;
        }
        while(s>s2){
            b='0'+b;
            s2++;
        }
        int flag=0;
        for(int i=s-1;i>=0;i--){
            int sum= a[i]+b[i]-2*'0'+flag;
            a[i]= sum%2+'0';
            flag= sum/2;
        }
        if(flag>0)
            a='1'+a;
        return a;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

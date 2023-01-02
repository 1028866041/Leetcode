//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 293 👎 0

#include<string>
#include<iostream>
#include<unordered_map>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> map;
        int res=0,j=0;
        for(char c:s)
            map[c]+= 1;
        unordered_map<char,int>::iterator iter;
        for(iter=map.begin();iter!=map.end();++iter){
            int val= iter->second;
            res+= val/2*2;
            if(val%2==1&& res%2==0)
                res++;
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 149 👎 0

#include<string>
#include<iostream>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string reverseVowels(string s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s[i]!='a'&&s[i]!='e'&&
                s[i]!='i'&&s[i]!='o'&&s[i]!='u'&&
                s[i]!='A'&&s[i]!='E'&&
                s[i]!='I'&&s[i]!='O'&&s[i]!='U'){
                i++;
                continue;
            }
            if(s[j]!='a'&&s[j]!='e'&&
                s[j]!='i'&&s[j]!='o'&&s[j]!='u'&&
                s[j]!='A'&&s[j]!='E'&&
                s[j]!='I'&&s[j]!='O'&&s[j]!='U'){
                j--;
                continue;
            }
            char ch=s[i];
            s[i]= s[j];
            s[j]= ch;
            i++;
            j--;
        }
        return s;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

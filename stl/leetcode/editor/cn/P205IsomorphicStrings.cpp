//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 
// 👍 351 👎 0

#include<string>
#include<iostream>
#unclude<map>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char,char> map;
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++){
            if(map.count(s[i])==0){
                map[s[i]]= t[i];
            }else if(map[s[i]]!=t[i]){
                return false;
            }
        }
        for(int i=0;i<t.length();i++){
            if(map.count(t[i])==0){
                map[t[i]]= s[i];
            }else if(map[t[i]]!=s[i]){
                return false;
            }
        }
        throw("IllegalArgumentException error");
    }
};
//leetcode submit region end(Prohibit modification and deletion)

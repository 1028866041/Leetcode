//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 341 👎 0

#include<string>
#include<iostream>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string convertToTitle(int columnNumber) {
        string str="";
        while(columnNumber>0){
            if(columnNumber!=26){
                str= char(columnNumber%26+'A'-1)+str;
            }else{
                columnNumber-=26;
                str= 'Z'+str;
            }
            columnNumber/= 26;
        }
        return str;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

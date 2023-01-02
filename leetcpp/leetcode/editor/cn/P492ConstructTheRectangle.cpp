#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> constructRectangle(int area) {
        int i= sqrt(area);
        vector<int> vec;
        while(i>0){
            if(area%i==0){
                vec.push_back(area/i);
                vec.push_back(i);
                break;
            }
            i--;
        }
        return vec;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

//请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。 
// 你的实现应该支持如下操作： 
// 
// Operations() 构造函数 
// minus(a, b) 减法，返回a - b 
// multiply(a, b) 乘法，返回a * b 
// divide(a, b) 除法，返回a / b 
// 
// 示例： 
// Operations operations = new Operations();
//operations.minus(1, 2); //返回-1
//operations.multiply(3, 4); //返回12
//operations.divide(5, -2); //返回-2
// 
// 提示： 
// 
// 你可以假设函数输入一定是有效的，例如不会出现除法分母为0的情况 
// 单个用例的函数调用次数不会超过1000次 
// 
// Related Topics 设计 
// 👍 9 👎 0

package leetcode.editor.cn;

public class P16_09OperationsLcci{
    public static void main(String[] args) {
        // TO TEST
        Operations solution = new P16_09OperationsLcci().new Operations();
        System.out.println(solution.divide(5,-2));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Operations {

    public Operations() {
    }
    
    public int minus(int a, int b) {
        return a+ ~b+1;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int divide(int a, int b) {
        if(b!=0){
            return a/b;
        }
        return -1;
    }
}

/**
 * Your Operations object will be instantiated and called as such:
 * Operations obj = new Operations();
 * int param_1 = obj.minus(a,b);
 * int param_2 = obj.multiply(a,b);
 * int param_3 = obj.divide(a,b);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
//力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令
//有两种： 
//
// 
// U: 向y轴正方向移动一格 
// R: 向x轴正方向移动一格。 
// 
//
// 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。 
//
// 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。 
//
// 
//
// 示例 1： 
//
// 输入：command = "URR", obstacles = [], x = 3, y = 2
//输出：true
//解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。 
//
// 示例 2： 
//
// 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
//输出：false
//解释：机器人在到达终点前会碰到(2, 2)的障碍物。 
//
// 示例 3： 
//
// 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
//输出：true
//解释：到达终点后，再碰到障碍物也不影响返回结果。 
//
// 
//
// 限制： 
//
// 
// 2 <= command的长度 <= 1000 
// command由U，R构成，且至少有一个U，至少有一个R 
// 0 <= x <= 1e9, 0 <= y <= 1e9 
// 0 <= obstacles的长度 <= 1000 
// obstacles[i]不为原点或者终点 
// 
// 👍 77 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class PLCP03ProgrammableRobot{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new PLCP03ProgrammableRobot().new Solution();
        System.out.println(solution.robot("URR", new int[][]{{4,2}}, 3,2));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int i=0,j=0,k=0;
        Arrays.sort(obstacles, (v1,v2)->(v1[0]-v2[0]));
        while(true){
            k= k%(command.length());
            if(command.charAt(k)=='R'){
                i+=1;
            }
            if(command.charAt(k)=='U'){
                j+=1;
            }
            if(i>x|| j>y){
                return false;
            }

            for(int l=0;l<obstacles.length;l++){
                if(i<obstacles[0][0]|| i>obstacles[obstacles.length-1][0]){
                   break;
                }
                if(i==obstacles[l][0]&& j==obstacles[l][1])
                    return false;
            }
            if(x==i&& y==j){
                return true;
            }
            k++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
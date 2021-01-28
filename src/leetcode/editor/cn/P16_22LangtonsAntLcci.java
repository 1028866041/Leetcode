//一只蚂蚁坐在由白色和黑色方格构成的无限网格上。开始时，网格全白，蚂蚁面向右侧。每行走一步，蚂蚁执行以下操作。 
//
// (1) 如果在白色方格上，则翻转方格的颜色，向右(顺时针)转 90 度，并向前移动一个单位。 
//(2) 如果在黑色方格上，则翻转方格的颜色，向左(逆时针方向)转 90 度，并向前移动一个单位。 
//
// 编写程序来模拟蚂蚁执行的前 K 个动作，并返回最终的网格。 
//
// 网格由数组表示，每个元素是一个字符串，代表网格中的一行，黑色方格由 'X' 表示，白色方格由 '_' 表示，蚂蚁所在的位置由 'L', 'U', 'R',
// 'D' 表示，分别表示蚂蚁 左、上、右、下 的朝向。只需要返回能够包含蚂蚁走过的所有方格的最小矩形。 
//
// 示例 1: 
//
// 输入: 0
//输出: ["R"]
// 
//
// 示例 2: 
//
// 输入: 2
//输出:
//[
//  "_X",
//  "LX"
//]
// 
//
// 示例 3: 
//
// 输入: 5
//输出:
//[
//  "_U",
//  "X_",
//  "XX"
//]
// 
//
// 说明： 
//
// 
// K <= 100000 
// 
// Related Topics 数组 
// 👍 10 👎 0

package leetcode.editor.cn;

import javafx.geometry.Pos;

import javax.swing.text.Position;
import java.util.*;

public class P16_22LangtonsAntLcci{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P16_22LangtonsAntLcci().new Solution();
        System.out.println(solution.printKMoves(5));
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private class Position{
        int x,y;
        public Position(int x, int y){
            this.x= x;
            this.y= y;
        }
        @Override
        public boolean equals(Object obj){
            if(obj==this)
                return true;
            if(!(obj instanceof Position))
                return false;
            Position o=(Position)obj;
            return x==o.x&&y==o.y;
        }
        @Override
        public int hashCode(){
            int i= x;
            i= i*30+y;
            return i;
        }
    }
    public List<String> printKMoves(int K) {
        char[] direction= {'L','U','R','D'};
        int[][] offset= {{-1,0},{0,-1},{1,0},{0,1}};
        Position pos= new Position(0,0);
        int dir=2;
        Set<Position> set= new HashSet<>();

        while(K>0) {
            Position t= new Position(pos.x, pos.y);
            if(set.add(t))
                dir= (dir+1)%4;
            else{
                dir= (dir+3)%4;
                set.remove(t);
            }
            pos.x+= offset[dir][0];
            pos.y+= offset[dir][1];
            K--;
        }

        int left= pos.x,top=pos.y,right=pos.x,bottom=pos.y;
        for(Position p: set){
            left= p.x<left?p.x:left;
            top= p.y<top?p.y:top;
            right= p.x>right?p.x:right;
            bottom= p.y>bottom?p.y:bottom;
        }

        char[][]grid= new char[bottom-top+1][right-left+1];
        for(char[] row:grid)
            Arrays.fill(row,'_');
        for(Position p:set)
            grid[p.y-top][p.x-left]= 'X';
        grid[pos.y-top][pos.x-left]= direction[dir];
        List<String> res= new ArrayList<>();
        for(char[] row:grid)
            res.add(String.valueOf(row));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
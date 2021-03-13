package company.HW;

import java.util.*;

public class HW_43 {
    static List<List<int[]>> res;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            res= new ArrayList<>();
            int m= sc.nextInt(),n=sc.nextInt();
            int[][] arry= new int[m][n];
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    arry[i][j]= sc.nextInt();
            backtrack(arry, new ArrayList<>(), new boolean[m][n], 0,0);
            Collections.sort(res, new Comparator<List<int[]>>() {
                @Override
                public int compare(List<int[]> o1, List<int[]> o2) {
                    return o1.size()-o2.size();
                }
            });
            for(int i=0;i<res.get(0).size();i++){
                System.out.println("("+res.get(0).get(i)[0]+","+res.get(0).get(i)[1]+")");
            }
        }
        sc.close();
    }

    public static void backtrack(int[][] arry, List<int[]> ls, boolean[][] visited,int i,int j) {
        if(arry[i][j]==1||visited[i][j]==true)
            return;
        if(i==arry.length-1&&j==arry[0].length-1){
            ls.add(new int[]{i,j});
            res.add(new ArrayList<>(ls));
            return;
        }
        ls.add(new int[]{i,j});
        visited[i][j]= true;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int[] d: dir){
            if(i+d[0]<arry.length&&j+d[1]<arry[0].length&&i+d[0]>=0&&j+d[1]>=0&&
                visited[i+d[0]][j+d[1]]==false&&arry[i+d[0]][j+d[1]]==0){
                backtrack(arry, ls, visited, i+d[0], j+d[1]);
                ls.remove(ls.size()-1);
            }
        }
        visited[i][j]=false;
    }
}
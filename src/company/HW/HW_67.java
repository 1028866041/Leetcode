package company.HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW_67 {
    static List<List<Integer>> res;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int[] num= new int[4];
            for(int i=0;i<4;i++)
                num[i]= sc.nextInt();
            res= new ArrayList<>();
            boolean flag=false;
            /*全排列backtrack+ dfs*/
            backtrack(num, new ArrayList<>(), new boolean[4]);
            for(int i=0;i<res.size();i++){
                for(int j=0;j<4;j++)
                    num[j]= res.get(i).get(j);
                if(traverse(num, num[0],1))
                    flag= true;
            }
            if(flag)
                System.out.println("true");
            else
                System.out.println("false");
        }
        sc.close();
    }

    public static void backtrack(int[] num, List<Integer> ls,boolean[] visited){
        if(ls.size()==num.length&&!res.contains(ls)){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<num.length;i++){
            if(visited[i])
                continue;
            visited[i]= true;
            ls.add(num[i]);
            backtrack(num, ls, visited);
            ls.remove(ls.size()-1);
            visited[i]= false;
        }
    }

    public static boolean traverse(int[] num, int cur, int idx){
        if(cur==24)
            return true;
        if(idx>=4||cur>24)
            return false;
        return traverse(num, cur+num[idx],idx+1)||
                traverse(num, cur-num[idx],idx+1)||
                 traverse(num, cur*num[idx],idx+1)||
                (num[idx]!=0&&cur%num[idx]==0&&traverse(num, cur/num[idx],idx+1));
    }
}
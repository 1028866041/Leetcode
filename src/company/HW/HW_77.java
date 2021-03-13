package company.HW;

import java.util.*;

public class HW_77 {
    static List<String> ls;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            int[] num= new int[m];
            ls= new ArrayList<>();
            Stack<Integer> stack= new Stack<>();
            for(int i=0;i<m;i++)
                num[i]= sc.nextInt();
            traverse(num,stack,"",0,0);
            Collections.sort(ls);
            for(String s:ls)
                System.out.println(s);
        }
        sc.close();
    }

    public static void traverse(int[] arry,
            Stack<Integer> stack,String str, int i,int j){
        if(arry.length==j)
            ls.add(str);
        if(!stack.isEmpty()){
            int k=stack.pop();
            traverse(arry, stack, str+k+" ",i,j+1);
            stack.push(k);
        }
        if(i<arry.length){
            stack.push(arry[i]);
            traverse(arry, stack, str,i+1,j);
            stack.pop();
        }
    }
}
package company.HW;

import java.util.Scanner;
import java.util.Stack;

public class HW_48 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt(),n=sc.nextInt();
            int[][] arry= new int[m-1][2];
            for(int i=0;i<m-1;i++){
                arry[i][0]= sc.nextInt();
                arry[i][1]= sc.nextInt();
            }
            int k= sc.nextInt();
            Stack<Integer> stack= new Stack<>();
            Stack<Integer> stack2= new Stack<>();
            stack.push(n);
            for(int i=0;i<m-1;i++){
                while(!stack.isEmpty()) {
                    if(stack.peek()==arry[i][1]){
                        stack.push(arry[i][0]);
                        while(!stack2.isEmpty())
                            stack.push(stack2.pop());
                        break;
                    }else
                        stack2.push(stack.pop());
                }
            }
            for(int i=0;i<m-1;i++){
                while(!stack.isEmpty()) {
                    if(stack.peek()==k){
                        stack.pop();
                        break;
                    }else
                        stack2.push(stack.pop());
                }
            }
            while(!stack.isEmpty())
                stack2.push(stack.pop());
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop()+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}

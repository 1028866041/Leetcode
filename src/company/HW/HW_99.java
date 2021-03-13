package company.HW;

import java.util.Scanner;

public class HW_99 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt(),n=0;
            for(int i=0;i<=m;i++){
               String j= Integer.toString(i*i);
               String k= Integer.toString(i);
               if(j.substring(j.length()-k.length(),j.length()).equals(k))
                   n++;
            }
            System.out.println(n);
        }
        sc.close();
    }
}
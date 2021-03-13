package company.HW;

import java.util.Scanner;

public class HW_55 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            int n=0;
            for(int i=7;i<=m;i++){
                if(i%7==0||Integer.toString(i).contains("7"))
                    n++;
            }
            System.out.println(n);
        }
        sc.close();
    }
}

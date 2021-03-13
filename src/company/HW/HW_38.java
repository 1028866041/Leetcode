package company.HW;

import java.util.Scanner;

public class HW_38 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            double l=m,s= l;
            for(int i=0;i<5;i++){
                s+=l;
                l=l/2.0;
            }
            s-=l*2;
            System.out.println(s);
            System.out.println(l);
        }
        sc.close();
    }
}

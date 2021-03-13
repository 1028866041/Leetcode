package company.HW;

import java.util.Scanner;

public class HW_6 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        long m= sc.nextLong();
        for(long i=2;i*i<=m;i++){
            while(m%i==0){
                System.out.print(i+" ");
                m/= i;
            }
        }
        System.out.print(m==1?"": m+" ");
    }
}

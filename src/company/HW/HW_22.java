package company.HW;

import java.util.Scanner;

public class HW_22 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            if(m>0)
                System.out.println(m/2);
        }
        sc.close();
    }
}

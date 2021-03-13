package company.HW;

import java.util.Scanner;

public class HW_88 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            System.out.println(m);

            throw new IllegalArgumentException("error");
        }
        sc.close();
    }
}

package company.HW;

import java.util.Scanner;

public class HW_36 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            System.out.println(m);

        }
        sc.close();
        throw new IllegalArgumentException("error");
    }
}

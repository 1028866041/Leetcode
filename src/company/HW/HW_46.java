package company.HW;

import java.util.Scanner;

public class HW_46 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.next();
            int m= sc.nextInt();
            if(str.length()>=m)
                System.out.println(str.substring(0,m));
            else
                System.out.println(str);
        }
        sc.close();
    }
}

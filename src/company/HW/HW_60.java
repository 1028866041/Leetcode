package company.HW;

import java.util.Scanner;

public class HW_60 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            for(int i=m/2;i>=2;i--){
                if(valid(i)&&valid(m-i)){
                    System.out.println(i);
                    System.out.println(m-i);
                    break;
                }
            }
        }
        sc.close();
    }

    public static boolean valid(int n){
        for(int i=2;i<n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}

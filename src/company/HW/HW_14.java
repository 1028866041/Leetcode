package company.HW;

import java.util.Arrays;
import java.util.Scanner;

public class HW_14 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            String[] str= new String[m];
            for(int i=0;i<m;i++)
                str[i]= sc.next();
            Arrays.sort(str);
            for(int i=0;i<m;i++)
                System.out.println(str[i]);
        }
        sc.close();
    }
}

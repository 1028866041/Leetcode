package company.HW;

import java.util.Scanner;

public class HW_4 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.nextLine();
            char[][] num= new char[(str.length()+7)/8][8];
            for(int i=0;i<str.length();i++)
                num[i/8][i%8]= str.charAt(i);
            for(int i=str.length();i<num.length*8;i++)
                num[i/8][i%8]= '0';
            for(int i=0;i<num.length;i++){
                for(int j=0;j<num[0].length;j++)
                    System.out.print(num[i][j]);
                System.out.println();
            }
        }
        sc.close();
    }
}
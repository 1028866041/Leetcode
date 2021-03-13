package company.HW;

import java.util.Scanner;

public class HW_40 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.nextLine().toCharArray();
            int[] arry=new int[4];
            for(char c:str){
                if(Character.isLetter(c)){
                    arry[0]++;
                }else if(c==' '){
                    arry[1]++;
                }else if(Character.isDigit(c)){
                    arry[2]++;
                }else{
                    arry[3]++;
                }
            }
            for(int i=0;i<4;i++)
                System.out.println(arry[i]);
        }
        sc.close();
    }
}

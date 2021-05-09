package company.ZJ;

import java.util.Scanner;

public class ZJ_18 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int j= Integer.parseInt(sc.nextLine());
        while(j>0){
            String str= sc.nextLine();
            for(int i=1;i<str.length()-1;i++){
                if(str.charAt(i-1)==str.charAt(i)){
                    if(str.charAt(i+1)==str.charAt(i)){
                        str= str.substring(0,i+1)+str.substring(i+2,str.length());
                        i--;
                    }else if(i<str.length()-2&&str.charAt(i+1)==str.charAt(i+2)){
                        str= str.substring(0,i+1)+str.substring(i+2,str.length());
                        i--;
                    }
                }
            }
            System.out.println(str);
            j--;
        }
    }
}

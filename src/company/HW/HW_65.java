package company.HW;

import java.util.Scanner;

public class HW_65 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str1= sc.nextLine();
            String str2= sc.nextLine();
            if(str1.length()>str2.length()){
                String tmp=str1;
                str1= str2;
                str2= tmp;
            }
            String res="";
            for(int i=0;i<str1.length()-1;i++)
                for(int j=i;j<str1.length();j++){
                    if(str2.contains(str1.substring(i,j+1))&&(j-i+1>res.length()))
                        res= str1.substring(i,j+1);
                }
            System.out.println(res);
        }
        sc.close();
    }
}
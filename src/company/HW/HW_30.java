package company.HW;

import java.util.Arrays;
import java.util.Scanner;

public class HW_30 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String s1= sc.next();
            String s2= sc.next();
            String s3= s1+s2;
            char[] n1= new char[(s3.length()+1)/2];
            char[] n2= new char[s3.length()-(s3.length()+1)/2];
            for(int i=0;i<(s3.length()+1)/2;i++){
                n1[i]= s3.charAt(i*2);
                if(i<n2.length){
                    n2[i]= s3.charAt(i*2+1);
                }
            }
            Arrays.sort(n1);
            Arrays.sort(n2);
            s3="";
            for(int i=0;i<n1.length;i++){
                s3+= n1[i];
                if(i<n2.length)
                    s3+= n2[i];
            }
            String str1= "0123456789abcdefABCDEF";
            String str2= "084C2A6E195D3B7F5D3B7F";
            for(int i=0;i<s3.length();i++){
                if(Character.isDigit(s3.charAt(i))||(s3.charAt(i)>='a'&&s3.charAt(i)<='f')||(s3.charAt(i)>='A'&&s3.charAt(i)<='F')){
                    for(int j=0;j<str1.length();j++){
                        if(s3.charAt(i)==str1.charAt(j)){
                            System.out.print(str2.charAt(j));
                        }
                    }
                }else{
                    System.out.print(s3.charAt(i));
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
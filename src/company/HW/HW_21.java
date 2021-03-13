package company.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW_21 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s1="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String s2="bcdefghijklmnopqrstuvwxyza22233344455566677778889999";
        while(sc.hasNext()){
            String str= sc.next(),res="";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)<'0'||str.charAt(i)>'9') {
                    for(int j=0;j<s1.length();j++){
                        if(s1.charAt(j)==str.charAt(i))
                            res+= s2.charAt(j);
                    }
                }else
                    res+= str.charAt(i);
            }
            System.out.print(res);
        }
        sc.close();
    }
}

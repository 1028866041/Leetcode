package company.HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW_57 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str1=sc.next(),str2=sc.next();
            if(str1.length()>str2.length()){
                String tmp= str2;
                str2= str1;
                str1= tmp;
            }
            int k=0;
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<str1.length();i++){
                if(Character.isDigit(str1.charAt(str1.length()-1-i))&&Character.isDigit(str2.charAt(str2.length()-1-i))){
                    int j= Integer.parseInt(str1.charAt(str1.length()-1-i)+"")+Integer.parseInt(str2.charAt(str2.length()-1-i)+"")+k;
                    k=j/10;
                    j=j%10;
                    ls.add(j);
                }
            }
            if(str1.length()==str2.length()&&k>0){
                ls.add(1);
            }else{
                for(int i=str1.length();i<str2.length();i++){
                    if(Character.isDigit(str2.charAt(str2.length()-1-i))){
                        int j=Integer.parseInt(str2.charAt(str2.length()-1-i)+"")+k;
                        k=j/10;
                        ls.add(j%10);
                    }
                }
            }
            Collections.reverse(ls);
            if(ls.get(0)==0&&ls.size()>1)
                System.out.print(1);
            for(int i=0;i<ls.size();i++){
                System.out.print(ls.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
}
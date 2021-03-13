package company.HW;

import java.util.*;

public class HW_81 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.next().toCharArray();
            char[] str2= sc.next().toCharArray();
            Set<Character> set= new TreeSet<>();
            Set<Character> set2= new TreeSet<>();
            for(char c:str)
                set.add(c);
            for(char c:str2)
                set2.add(c);
            boolean flag=true;
            for(char c:set){
                if(!set2.contains(c)){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag);
        }
        sc.close();
    }
}
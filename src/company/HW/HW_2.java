package company.HW;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HW_2 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.next();
            Set<Character> set= new HashSet<>();
            for(int i=0;i<str.length();i++)
                if(!set.contains(str.charAt(i)))
                    set.add(str.charAt(i));
            System.out.println(set.size());
        }
        sc.close();
    }
}

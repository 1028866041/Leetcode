package company.HW;

import java.util.*;

public class HW_9 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.next(),strs="";
            List<Character> list= new ArrayList<>();
            for(int i=str.length()-1;i>=0;i--)
                if(!list.contains(str.charAt(i)))
                    list.add(str.charAt(i));
            for(Character c:list)
                strs+= c;
            System.out.println(Integer.parseInt(strs));
        }
        sc.close();
    }
}

package company.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW_59 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.nextLine().toCharArray();
            Map<Character,Integer> map=new HashMap<>();
            for(char c:str){
                map.put(c, map.getOrDefault(c,0)+1);
            }
            int flag=0;
            for(char key:map.keySet()){
                if(map.get(key)==1){
                    flag=1;
                    System.out.println(key);
                    break;
                }
            }
            if(flag==0)
                System.out.println(-1);
        }
        sc.close();
    }
}

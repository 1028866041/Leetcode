package company.HW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW_45 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            String[] str= new String[m];
            for(int i=0;i<m;i++)
                str[i]= sc.next().toLowerCase();
            for(int i=0;i<m;i++){
                Map<Character,Integer> map= new HashMap<>();
                for(int j=0;j<str[i].length();j++)
                    map.put(str[i].charAt(j), map.getOrDefault(str[i].charAt(j),0)+1);
                int max=0,k=0;
                int[] num= new int[map.size()];
                for(int j:map.values()){
                    num[k]= j;
                    k++;
                }
                Arrays.sort(num);
                for(k=num.length-1;k>=0;k--)
                    max+= num[k]*(27+k-num.length);
                System.out.println(max);
            }
        }
        sc.close();
    }
}

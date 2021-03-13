package company.TX;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TX_7 {
    static Map<Long,Long> map= new HashMap<>();
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        long m= sc.nextLong();
        sc.close();
        map.put(0L,1L);
        map.put(1L,1L);
        System.out.println(valid(m));
    }

    public static long valid(long m){
        if(map.containsKey(m))
            return map.get(m);
        long res=0;
        if(m%2!=1)
            res= valid(m/2)+valid(m/2-1);
        else
            res= valid(m/2);
        map.put(m,res);
        return res;
    }
}

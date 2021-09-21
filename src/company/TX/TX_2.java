package company.TX;

import java.util.*;

public class TX_2 {
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<gifts.length;i++){
            if(map.getOrDefault(gifts[i],0)+1>=n/2)
                return gifts[i];
            map.put(gifts[i], map.getOrDefault(gifts[i],0)+1);
        }
        return 0;
    }
}

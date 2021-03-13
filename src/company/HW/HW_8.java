package company.HW;

import java.util.*;

public class HW_8 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            Map<Integer,Integer> map= new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for(int i=0;i<m;i++){
                int j= sc.nextInt();
                int k= sc.nextInt();
                if(map.containsKey(j))
                    map.put(j, map.get(j)+k);
                else
                    map.put(j, k);
            }
            for(int i:map.keySet())
                System.out.println(i +" "+map.get(i));
        }
        sc.close();
    }
}

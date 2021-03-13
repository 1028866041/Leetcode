package company.HW;

import java.util.*;

public class HW_102 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.nextLine().toCharArray();
            Map<Character,Integer> map=new HashMap<>();
            for(char c:str)
                map.put(c, map.getOrDefault(c,0)+1);
            int[][] arry= new int[map.size()][2];
            int  i=0;
            for(char c:map.keySet()){
                arry[i][0]= c;
                arry[i][1]= map.get(c);
                i++;
            }
            Arrays.sort(arry, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]!=o2[1]){
                        return o2[1]-o1[1];
                    }else{
                        return o1[0]-o2[0];
                    }
                }
            });
            for(i=0;i<arry.length;i++)
                System.out.print((char)arry[i][0]);
            System.out.println();
        }
        sc.close();
    }
}
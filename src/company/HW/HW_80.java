package company.HW;

import java.util.*;

public class HW_80 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<m;i++){
                int j=sc.nextInt();
                if(!ls.contains(j))
                    ls.add(j);
            }
            int n= sc.nextInt();
            for(int i=0;i<n;i++){
                int j=sc.nextInt();
                if(!ls.contains(j))
                    ls.add(j);
            }
            Collections.sort(ls);
            for(int i=0;i<ls.size();i++)
                System.out.print(ls.get(i));
            System.out.println();
        }
        sc.close();
    }
}
package company.HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW_51 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<m;i++)
                ls.add(sc.nextInt());
            int k= sc.nextInt();
            if(k>0&&ls.size()>=k)
                System.out.println(ls.get(ls.size()-k));
            else
                System.out.println(0);
        }
        sc.close();
    }
}
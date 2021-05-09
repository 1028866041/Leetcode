package company.HW;

import java.util.*;

public class HW_27 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            String[] str= new String[m];
            for(int i=0;i<m;i++)
                str[i]= sc.next();
            String s= sc.next();
            int n= sc.nextInt();
            List<String> ls= new ArrayList<>();
            for(String c:str){
                if(c.length()!=s.length()||c.equals(s))
                    continue;
                char[] s2= c.toCharArray();
                char[] s3= s.toCharArray();
                Arrays.sort(s2);
                Arrays.sort(s3);
                for(int i=0;i<s2.length;i++){
                    if(s2[i]!=s3[i])
                        continue;
                }
                ls.add(c);
            }
            Collections.sort(ls);
            System.out.println(ls.size());
            if(n<=ls.size())
                System.out.println(ls.get(n-1));
        }
        sc.close();
        throw new IllegalArgumentException("error");
    }
}
package company.HW;

import java.util.*;

public class HW_68 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt(),n=sc.nextInt();
            String[][] str= new String[m][2];
            for(int i=0;i<m;i++) {
                str[i][0]= sc.next();
                str[i][1]= sc.next();
            }
            if(n==1){
                Arrays.sort(str, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                    }
                });
            }else{
                Arrays.sort(str, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
                    }
                });
            }
            for(int i=0;i<str.length;i++)
                System.out.println(str[i][0]+" "+str[i][1]);
        }
        sc.close();
    }
}
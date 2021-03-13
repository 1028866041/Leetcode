package company.HW;

import java.util.Scanner;

public class HW_63 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.nextLine().toCharArray();
            int m= sc.nextInt(),i=0;
            int[] num= new int[str.length-m];
            for(i=0;i<num.length;i++){
                for(int j=0;j<m;j++) {
                    if (str[i+j] == 'G' || str[i+j] == 'C')
                        num[i]++;
                }
            }
            int max= Integer.MIN_VALUE;
            for(int j:num)
                max= Math.max(max, j);
            for(i=0;i<num.length;i++){
                if(num[i]==max)
                    break;
            }
            String strs="";
            for(int j=0;j<m;j++)
                strs+=str[i+j];
            System.out.println(strs);
        }
        sc.close();
    }
}
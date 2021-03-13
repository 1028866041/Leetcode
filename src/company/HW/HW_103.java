package company.HW;

import java.util.Scanner;

public class HW_103 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            int[] arry= new int[m];
            int[] dp= new int[m];
            for(int i=0;i<m;i++)
                arry[i]= sc.nextInt();
            for(int i=0;i<m;i++){
                dp[i]= 1;
                for(int j=0;j<i;j++){
                    if(arry[i]>arry[j])
                        dp[i]= Math.max(dp[i], dp[j]+1);
                }
            }
            int max= 0;
            for(int i=0; i<m; i++)
                if(dp[i]>max)
                    max= dp[i];
            System.out.println(max);
        }
        sc.close();
    }
}

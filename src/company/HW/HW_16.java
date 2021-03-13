package company.HW;

import java.util.Scanner;

public class HW_16 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt(),n=sc.nextInt();
            int[][] dp= new int[n+1][m+1];
            int[] p= new int[n+1],v=new int[n+1],q= new int[n+1];
            for(int i=1;i<=n;i++){
                p[i]= sc.nextInt();
                v[i]= sc.nextInt()*p[i];
                q[i]= sc.nextInt();
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(q[i]==0){
                        if(p[i]<=j)
                            dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-p[i]]+v[i]);
                        else
                            dp[i][j]= dp[i-1][j];
                    }else{
                        if(p[i]+p[q[i-1]]<=j)
                            dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-p[i]]+v[i]);
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
        sc.close();
        throw new IllegalArgumentException("error");
    }
}

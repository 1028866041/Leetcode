package company.HW;

import java.util.Scanner;

public class HW_35 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            int[][] arry= new int[m][m];
            arry[0][0]=1;
            for(int i=1;i<m;i++)
                arry[0][i]= arry[0][i-1]+i+1;
            for(int i=1;i<m;i++){
                arry[i][0]= arry[i-1][0]+i;
                for(int j=1;j<m-i;j++){
                    arry[i][j]= arry[i][j-1]+i+j+1;
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<m-i;j++)
                    System.out.print(arry[i][j]+" ");
                System.out.println();
            }
        }
        sc.close();
    }
}

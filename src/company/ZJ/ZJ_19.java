package company.ZJ;

import java.util.Scanner;

public class ZJ_19 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            long res= 0;
            int m= sc.nextInt(),n= sc.nextInt();
            int[] num= new int[m];
            for(int i=0;i<m;i++)
                num[i]= sc.nextInt();
            for(int i=0,j=0;i<num.length;i++){
                while(i>=2&& num[i]-num[j]>n){
                    j++;
                }
                res+= (long)(i-j)*(long)(i-j-1)/2;
            }
            System.out.println(res%99997867);
        }
    }
}

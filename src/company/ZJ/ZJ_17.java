package company.ZJ;
import java.util.Scanner;

public class ZJ_17 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt(),n= sc.nextInt();
            boolean flag=false;
            for(int i=m;i<=n;i++){
                if(valid(i)){
                    flag|=true;
                    System.out.print(i+" ");
                }
            }
            if(!flag)
                System.out.print("no");
            System.out.println();
        }
    }

    public static boolean valid(int m){
        int i=m,k=0;
        while(i>0){
            int j= i%10;
            k+= Math.pow(j,3);
            i=i/10;
        }
        return k==m;
    }

}

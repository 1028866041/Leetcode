package company.HW;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HW_49 {
    static ReentrantLock lock= new ReentrantLock();
    static Condition c= lock.newCondition();
    static Condition c2= lock.newCondition();
    static Condition c3= lock.newCondition();
    static Condition c4= lock.newCondition();
    static int count= 0;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int m= sc.nextInt();
            Thread thread= new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        lock.lock();
                        for(int i=0;i<m;i++){
                            while(count%4!=0)
                                c.await();
                            System.out.print('A');
                            count++;
                            c2.signal();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            });
            Thread thread2= new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        lock.lock();
                        for(int i=0;i<m;i++){
                            while(count%4!=1)
                                c2.await();
                            System.out.print('B');
                            count++;
                            c3.signal();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            });
            Thread thread3= new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        lock.lock();
                        for(int i=0;i<m;i++){
                            while(count%4!=2)
                                c3.await();
                            System.out.print('C');
                            count++;
                            c4.signal();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            });
            Thread thread4= new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        lock.lock();
                        for(int i=0;i<m;i++){
                            while(count%4!=3)
                                c4.await();
                            System.out.print('D');
                            count++;
                            c.signal();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            });
            thread.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }
        sc.close();
    }
}
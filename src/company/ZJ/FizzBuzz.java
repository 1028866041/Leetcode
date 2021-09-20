package company.main;

public class FizzBuzz {
    private int n;
    private int num = -1;
    private final Object mutex= new Object();
    public FizzBuzz(int n) {
        this.n = n;
    }
    /*
    public void fizz(Runnable printFizz) {
        synchronized (mutex){
            while(num<=n){
                if(num%3!=0|| num%5==0){
                    mutex.wait();
                    continue;
                }
            }
            printFizz.run();
            num++;
            mutex.notify();
        }
    }
    public void buzz(Runnable printBuzz) {
        synchronized (mutex){
            while(num<=n){
                if(num%3==0|| num%5!=0){
                    mutex.wait();
                    continue;
                }
            }
            printBuzz.run();
            num++;
            mutex.notify();
        }
    }
    public void fizzbuzz(Runnable printFizzBuzz) {
        synchronized (mutex){
            while(num<=n){
                if(num%3!=0|| num%5!=0){
                    mutex.wait();
                    continue;
                }
            }
            printFizzBuzz.run();
            num++;
            mutex.notify();
        }
    }
    public void number(IntConsumer printNumber) {
        synchronized (mutex){
            while(num<=n){
                if(num%3==0|| num%5==0){
                    mutex.wait();
                    continue;
                }
            }
            printNumber.accept(num);
            num++;
            mutex.notify();
        }
    }*/
}
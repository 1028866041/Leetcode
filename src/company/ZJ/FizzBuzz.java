package company.main;

public class FizzBuzz {
    private int n;
    private int num = -1;
    private final Object mutex= new Object();
    public FizzBuzz(int n) {
        this.n = n;
    }
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
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
    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
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
    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (mutex){
            while(num<=n){
                if(num%3!=0|| num%5!=0){
                    mutex.wait(); //enter wait queue
                    continue;
                }
            }
            printFizzBuzz.run();
            num++;
            mutex.notify();
        }
    }
    /*
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
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
    }
    */
}
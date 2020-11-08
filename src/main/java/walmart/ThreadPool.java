package walmart;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        Runnable r1 =new Factorial(4,"First");
        Runnable r2 =new Factorial(5,"second");
        Runnable r3 =new Factorial(6,"third");
        Runnable r4 =new Factorial(8,"four");
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);
        executor.execute(r4);
        executor.shutdown();
    }
}

class Factorial implements Runnable{
    int number;
    String threadName;

    public Factorial(int num,String threadName){
        this.number = num;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if(number == 1){
            System.out.println(1);
        }else{
            int fact =1;
            for(int i =1;i<=number;i++){
                fact = fact*i;
            }
            System.out.println(threadName+":"+fact);
        }
    }
}

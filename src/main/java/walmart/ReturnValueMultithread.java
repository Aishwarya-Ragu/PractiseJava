package walmart;

import java.util.concurrent.*;

public class ReturnValueMultithread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Factorials f = new Factorials(3,"First");
        Future<Integer> fu =executor.submit(f);
        System.out.println(fu.get());
        executor.shutdown();
    }
}

class Factorials implements Callable<Integer>{
    int num;
    String threadName;
    public Factorials(int num,String threadName){
        this.num = num;
        this.threadName = threadName;
    }

    @Override
    public Integer call() throws Exception {
        int fact =1;
        for(int i =1;i<=num;i++){
            fact = fact*i;
        }
        return fact;
    }
}

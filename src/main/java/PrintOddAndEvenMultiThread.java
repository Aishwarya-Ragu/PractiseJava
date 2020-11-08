public class PrintOddAndEvenMultiThread {
    public static void main(String[] args) {
        Shared shared= new Shared();
        Thread t1 = new Thread(new OddThread(10,shared));
        t1.setName("Odd thread");
        Thread t2 = new Thread(new EvenThread(10,shared));
        t2.setName("Even thread");
        t1.start();
        t2.start();
    }
}

class OddThread implements Runnable{
    int limit;
    Shared shared;
    OddThread(int limit,Shared shared){
        this.limit = limit;
        this.shared = shared;
    }

    @Override
    public void run() {
        for(int i =1;i<=limit;i = i+2){
            shared.printOdd(i);
        }
    }
}

class EvenThread implements Runnable{
    int limit;
    Shared shared;
    EvenThread(int limit,Shared shared){
        this.limit = limit;
        this.shared = shared;
    }

    @Override
    public void run() {
        for(int i =2;i<=limit;i = i+2){
            shared.printEven(i);
        }
    }
}

class Shared{
    volatile boolean evenFlag = false;
    void printOdd(int num){
        synchronized (this){
            while(evenFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+num);
            evenFlag = true;
            notify();

        }

    }
    void printEven(int num){
        synchronized (this){
            while(!evenFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+num);
            evenFlag = false;
            notify();

        }

    }
}

import java.util.ArrayList;
import java.util.List;

public class MultiThread {
    public static void main(String args[]){
        System.out.println("Inside main");
        MultiThread mt = new MultiThread();
        mt.nthUglyNumber(10);
        /*TestThread t = new TestThread();
        System.out.println("ThreadName:"+t.getName());
        System.out.println("ThreadName:"+t.getId());
        t.run();*/
    }

    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();

        int num = 1;
        int i = num;
        while(list.size() < n){
            i = maxDivide(i,2);
            i = maxDivide(i,3);
            i = maxDivide(i,5);
            if(i == 1)
                list.add(num);
            num++;
            i = num;
        }
        return list.get(n-1);
    }

    public int maxDivide(int a , int b){
        while(a%b == 0)
            a = a/b;
        return a;
    }
}




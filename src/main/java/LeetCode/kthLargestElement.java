package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargestElement {
    public static void main(String[] args) {
        int k =3;
        CustomComparator customComparator = new CustomComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1,customComparator);
        int a[]={10,7,8,9,4,2,6};
        for(int num :a){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        System.out.println(pq.poll());
    }
}

class CustomComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer t, Integer t1) {
        return t1.compareTo(t);

    }
}

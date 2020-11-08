package May;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        int s =hd.hammingDistance(1,4);
        System.out.println(s);
        System.out.println(Integer.bitCount(1^4));

    }

    public LinkedList<Integer> appendZero(LinkedList<Integer> list, int diff){
        while(diff > 0){
            list.addFirst(0);
            diff--;
        }
        return list;
    }

    public int hammingDistance(int x, int y) {
        LinkedList<Integer> firstNum = findBinary(x);
        LinkedList<Integer> secondNum = findBinary(y);
        if(firstNum.size() < secondNum.size()){
            int diff = Math.abs(firstNum.size() - secondNum.size());
            appendZero(firstNum,diff);
        }
        if(firstNum.size() > secondNum.size()){
            int diff = Math.abs(firstNum.size() - secondNum.size());
            appendZero(secondNum,diff);
        }
        int i =0;
        int diff = 0;
        while(i<firstNum.size()){
            int f = firstNum.get(i)!=null?firstNum.get(i):0;
            int s = secondNum.get(i)!=null?secondNum.get(i):0;
            if(f != s){
                diff++;
            }
            i++;
        }
        return diff;
    }

    public LinkedList<Integer> findBinary(int num){
        LinkedList<Integer> list = new LinkedList<Integer>();
        while(num != 1){
            list.addFirst(num%2);
            num = num/2;
       }
        list.addFirst(1);
        return list;
    }
}

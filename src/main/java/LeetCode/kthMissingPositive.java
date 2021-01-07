package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class kthMissingPositive {
    public static void main(String[] args) {
        kthMissingPositive kmp = new kthMissingPositive();
        int num = kmp.findKthPositive(new int[] {1,2,3,4},2);
        System.out.println(num);
    }

    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int missNum = k;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int ptr = 1;
        while(k >=0 && i<len){
            if(arr[i] != ptr){
                list.add(ptr);
                k--;
            }
            else
                i++;
            ptr++;
        }
        if(k > 0){
            return arr[len-1]+k;
        }
        return list.get(missNum-1);
    }
}

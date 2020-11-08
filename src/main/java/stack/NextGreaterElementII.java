package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        NextGreaterElementII nge = new NextGreaterElementII();
        int[] a = nge.nextGreaterElement(new int[]{5,4,3,2,1});
        System.out.println(a);
    }
    public int[] nextGreaterElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> st = new Stack<Integer>();
        int last_poped =-1;
        int max_poped =-1;
        for(int num:nums){
            st.push(num);
            map.put(num,-1);
        }
        while(!st.isEmpty()){
            int ele = st.pop();
            if(map.containsKey(ele)){
                int value = last_poped > ele ? last_poped :(max_poped > ele) ? max_poped : -1;
                map.put(ele,value);
            }
            last_poped =ele;
            max_poped = Math.max(last_poped,max_poped);
        }
        int [] newArray = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            newArray[i] = map.get(nums[i]);
        }
        return newArray;



    }
}

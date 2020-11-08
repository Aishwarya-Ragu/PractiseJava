package stack;


import java.util.*;
import java.util.stream.Collectors;

public class NextGreaterElementI {
    public static void main(String[] args) {
        NextGreaterElementI nge = new NextGreaterElementI();
        int[] a = nge.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
        System.out.println(a);

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        Stack<Integer> st = new Stack<>();
        int last_poped=-1;
        int max_poped =-1;
        for(int num:nums1){
            map.put(num,-1);
        }
        for(int num:nums2){
            st.push(num);
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
        Collection<Integer> a = map.values();
        return a.stream().mapToInt(Integer::intValue).toArray();



    }
}
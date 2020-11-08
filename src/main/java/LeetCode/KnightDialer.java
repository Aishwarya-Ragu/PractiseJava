package LeetCode;

import java.util.*;

public class KnightDialer {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> knightMap = new HashMap<>();
        knightMap.put(0, Arrays.asList(4,6));
        knightMap.put(1, Arrays.asList(6,8));
        knightMap.put(2, Arrays.asList(7,9));
        knightMap.put(3, Arrays.asList(8,4));
        knightMap.put(4, Arrays.asList(3,9,0));
        knightMap.put(5, Arrays.asList());
        knightMap.put(6, Arrays.asList(1,7,0));
        knightMap.put(7, Arrays.asList(2,6));
        knightMap.put(8, Arrays.asList(1,3));
        knightMap.put(9, Arrays.asList(2,4));
        int hop = 2;
        List<Integer> newList = new ArrayList<>();
        newList.add(5);
        while(hop > 0){
            List<Integer> list = new ArrayList<>(newList);
            newList.clear();
            for(Integer num : list){
                newList.addAll(knightMap.get(num));
            }
            hop--;
        }
        System.out.println(newList.size());
    }
}

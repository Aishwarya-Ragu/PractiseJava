package Blind75;

import java.util.*;

public class kdiffPair {
    public static void main(String[] args) {
        int [] nums = {1,3,1,5,4};
        int k = 0;
        kdiffPair kpair = new kdiffPair();
        System.out.println(kpair.findPairs(nums,k));
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        int uniquePair = 0;
        for(int i =0;i<nums.length;i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i],val+1);
        }

        for(int i =0;i< nums.length;i++){
            int sumValue = nums[i]+k;
            if(map.containsKey(sumValue)){
                List<Integer> list = new ArrayList<>();
                if(( sumValue == nums[i] && map.get(nums[i]) > 1 ) || (sumValue!=nums[i])){
                    list.add(nums[i]);
                    list.add(sumValue);
                    uniquePair++;
                    set.add(list);

                }
            }
        }
        return set.size();
    }
}

package TopInterviewQuestions.Medium.Backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i],val+1);
        }

        int key[] = new int[map.size()];
        int value[] = new int[map.size()];
        int index=0;
        int[] output = new int[nums.length];
        Set<List<Integer>> list = new HashSet<>();
        for(Map.Entry<Integer,Integer> mapEntry :map.entrySet()){
            key[index] = mapEntry.getKey();
            value[index] = mapEntry.getValue();
            index++;
        }

        subsets sb = new subsets();
        sb.recurse(nums,key,value,output,list,0,0);
        list.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    private void recurse(int[] nums, int[] key, int[] value, int[] output, Set<List<Integer>> list, int level, int index) {
        List<Integer> listt = new ArrayList<>();
        for(int i =0;i<level;i++){
            listt.add((output[i]));
        }
        list.add(listt);
        for(int i = index;i<value.length;i++){
            if(value[i] == 0)
                continue;
            output[level] = key[i];
            value[i]--;
            recurse(nums,key,value,output,list,level+1, i);
            value[i]++;
        }

    }


}

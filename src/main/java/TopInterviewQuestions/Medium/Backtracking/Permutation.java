package TopInterviewQuestions.Medium.Backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        int[] nums ={1,2,3};
        p.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int val = countMap.getOrDefault(nums[i],0);
            countMap.put(nums[i],val+1);
        }
        int[] key = new int[countMap.size()];
        int[] value = new int[countMap.size()];
        List<List<Integer>> olist = new ArrayList<>();
        int[] output = new int[nums.length];
        int j =0;
        for(Map.Entry<Integer,Integer> entryMap :countMap.entrySet()){
            key[j] = entryMap.getKey();
            value[j] = entryMap.getValue();
            j++;
        }
        recursiveUtil(nums,key,value,olist,output,0);
        return olist;
    }

    private void recursiveUtil(int[] nums, int[] key, int[] value, List<List<Integer>> list, int[] output ,int level) {
        if(level == nums.length){
            List<Integer> outputList = Arrays.stream(output).mapToObj(i -> (Integer) i).collect(Collectors.toList());
            list.add(outputList);
            return;
        }
        for(int i =0;i<value.length;i++){
            if(value[i] == 0)
                continue;
            value[i]--;
            output[level] = key[i];
            recursiveUtil(nums, key, value, list, output,level+1);
            value[i]++;
        }
    }


}

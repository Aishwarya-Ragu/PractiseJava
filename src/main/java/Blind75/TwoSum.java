package Blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String args[]){
        int nums[]={2,7,11,15};
        int[] result = new int[2];
        //List<Integer> a= Arrays.stream(nums).mapToObj(num->(int)num).collect(Collectors.toList());
        Map<Integer,Integer> map = new HashMap<>();
        int target =9;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            int value = target - nums[i];
            if(map.containsKey(value)){
                result=  new int[] {map.get(value),i};
            }
        }
        Arrays.stream(result).forEach(c->System.out.println(c));

    }
}

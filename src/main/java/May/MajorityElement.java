package May;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String args[]){
        int [] nums = {2,2,1,1,1,2,2};
        int len = nums.length;
        Map<Integer,Integer> intMap = new HashMap<>();
        for(int i =0;i<len;i++){
            intMap.put(nums[i],intMap.getOrDefault(nums[i],0)+1);
            if(intMap.get(nums[i]) > len/2){
                System.out.println(nums[i]);
                break;
            }
        }

    }
}

package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    List<List<Integer>> listOfResult = new ArrayList<>();
    public static void main(String[] args) {
        int a[] = {-1,2,1,-4};
        ThreeSum ts = new ThreeSum();
        ts.threeSum(a);
        ts.threeSumClosest(a,1);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            if(i==0 || (i > 0 && nums[i] != nums[i-1])){
            int low = i+1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            while(low < high){
                if(nums[low] + nums[high] == sum){
                    listOfResult.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high - 1]) high --;
                    low++;
                    high--;

                }else if(nums[low] + nums[high] > sum){
                    high --;
                }else if(nums[low] + nums[high] < sum){
                    low ++;
                }
            }}
        }
        return listOfResult;
    }


    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int len = nums.length;
        for(int i =0;i<nums.length;i++){
            int low = i+1;
            int high = len - 1;
            while(low < high){
                int sum = nums[i]+nums[low]+nums[high];
                if(Math.abs(target-sum) < Math.abs(diff))
                    diff = target-sum;
                if(sum < target)
                    low++;
                else
                    high--;



            }
        }
        return target-diff;


    }


}

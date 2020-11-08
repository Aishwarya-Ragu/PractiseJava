package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Jump {
    public static void main(String[] args) {
        int nums[] = {2,0};

        List<List<Integer>> a = new ArrayList<>();
        Jump j = new Jump();
        System.out.println(j.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len-1){
            if(nums[i] == 0 )
                break;
            i = i + nums[i];
        }
        if(i == len-1 || i == len ){
            return true;
        }
        return false;
    }
}

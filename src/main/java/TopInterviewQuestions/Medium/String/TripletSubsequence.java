package TopInterviewQuestions.Medium.String;

public class TripletSubsequence {
    public static void main(String[] args) {
        int[]nums= {2,1,5,0,4,6};
        TripletSubsequence ts = new TripletSubsequence();
        System.out.println(ts.increasingTriplet(nums));

    }

    public boolean increasingTriplet(int[] nums) {
        boolean isIncreasing = false;
        int len =0;
        for(int i =0;i<nums.length;i++){
            int j =i+1;
            if(j < nums.length && nums[j] > nums[i]){
                isIncreasing = true;
                len++;
            }else{
                len =0;
                isIncreasing = false;
            }
            if(len == 2 && isIncreasing)
                break;
        }
        return isIncreasing;

    }

}

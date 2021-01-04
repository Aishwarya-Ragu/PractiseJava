package LeetCode;

public class MountainArray {
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        MountainArray ma = new MountainArray();
        System.out.println(ma.longestMountain(nums));
    }

    public int longestMountain(int[] arr) {
        int maxLength = 0;
        if(arr.length < 3)
            return maxLength;
        int i = 0;
        int j = i+1;
        int start =0;
        int end  =0;
        boolean ins= false;
        boolean dss = false;
        while(i<arr.length && j<arr.length){
            if(arr[i] < arr[j] && !dss && !ins){
                ins = true;
                start = i;
            }
            else if(arr[i] > arr[j] && ins)
                dss = true;
            else if(arr[i] < arr[j] && !dss){
                ins = true;
            }else if(arr[i] < arr[j] && dss){
                end = i;
                ins = false;
                dss = false;
            }
            maxLength = Math.max(maxLength,end-start);
            i++;
            j=i+1;

        }
        return  maxLength;
    }
}

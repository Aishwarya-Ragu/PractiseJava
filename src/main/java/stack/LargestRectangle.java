package stack;

public class LargestRectangle {
    public static void main(String args[]){
        LargestRectangle lr = new LargestRectangle();
        System.out.println(lr.largestRectangleArea(new int[]{2,3,4,2}));
    }
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)
            return 0;
        if(heights.length ==1){
            return heights[0];
        }
        int left =0;
        int len = heights.length-1;
        int right =len;

        int right_max = heights[right];
        int left_max=heights[left];
        int i =0;

        while(left<right){
            if(heights[left] < heights[right]){
                right_max= right_max>heights[right]?right_max:heights[right];
                left++;
            }else{
                left_max = left_max > heights[left]?left_max:heights[left];
                right--;
            }
        }
        return  left_max ==0 || right_max ==0 ? left_max+right_max: Math.min(left_max,right_max)+Math.min(left_max,right_max);



    }
}

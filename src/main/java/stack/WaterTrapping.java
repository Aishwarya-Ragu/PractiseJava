package stack;

import java.util.Stack;

public class WaterTrapping {
    public static void main(String args[]){
        WaterTrapping wt = new WaterTrapping();
        System.out.println(wt.trap(new int[]{3, 0, 2, 0, 4}));

    }
    public int trap(int[] height) {
        int fill =0;
        Stack<Integer> st = new Stack<Integer>();
        int i =0;
        int baseNum = 0;
        while(i<height.length){
            if(i == 0 && height[i] == 0) {
            }
            else{if(height[i] < baseNum){
                st.push(height[i]);
            }else if(height[i] >= baseNum){
                while(!st.isEmpty()){

                    fill+= baseNum - st.pop() ;
                }

                baseNum= height[i];
            }
            }
            i++;


        }

        return fill;

    }

}

package stack;

import sun.awt.X11.XStateProtocol;

import java.util.Stack;

public class DailyTemperature {
    Stack<Integer> st = new Stack<Integer>();

    public static void main(String args[]){
        DailyTemperature vp = new DailyTemperature();
        System.out.println(vp.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }


    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int median = T[0];
        int [] finalList = new int[len];
        int j =1;
        int i =0;
        while(i < len &&  j < len){
            if(T[j] > median){
                finalList[i] = j-i;
                i++;
                median = T[i];
                j = i+1;
            }else{
                st.push(T[j]);
                j++;
                if(j>=len){
                    i++;
                    median = T[i];
                    j =i+1;
                }
            }
         }
        return finalList;
    }
}

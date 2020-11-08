package May;

//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String args[]){
        String num ="10200";
                int k =2;
         Stack stack = new Stack();
         int i =0;
         while(i<num.length()){
             if(k>0 && !stack.isEmpty() && Integer.parseInt(stack.peek().toString()) > Integer.parseInt(String.valueOf(num.charAt(i)))){
                 stack.pop();
                 k--;
             }
            stack.push(num.charAt(i));
             i++;
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
             sb.append(stack.pop());

         }
        sb.reverse();
        int len = num.length();
        if(len-k!=len){
            sb.delete(len-k,len);
        }
        System.out.println(sb.toString());



        /*int i =0;
        int j=i+k;
        int smallInteger=0;
        while(j<num.length()){
            StringBuilder sb = new StringBuilder(num);
            StringBuilder str = sb.delete(i, j);
            smallInteger = i ==0 ? Integer.parseInt((str.toString())):Math.min(smallInteger,Integer.parseInt((str.toString())));
            i++;
            j = i+k;
        }
        System.out.println(String.valueOf(smallInteger));*/

    }

}

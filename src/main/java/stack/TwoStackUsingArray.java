package stack;

import java.util.Stack;

public class TwoStackUsingArray {
    int[] arr = new int[20];
    int top1 = -1;
    int top2 = arr.length;
    public static void main(String args[]){
        TwoStackUsingArray tw = new TwoStackUsingArray();

        tw.push1(2);
        tw.push1(2);

        tw.push1(8);

        tw.push2(2);

        tw.push2(2);
        tw.push2(7);

        tw.pop1();
        tw.pop2();

        tw.pop1();
        tw.pop2();
        tw.pop1();
        tw.pop2();
        tw.pop1();
        tw.pop2();
        tw.pop1();
        tw.pop2();






    }

    private void push1(int num) {
        if(top1 >=-1 && top1<top2){
            top1++;
            arr[top1] =num;


        }else{
            System.out.println("Exceded limit");
        }

    }

    private void push2(int num) {
        if(top2 <= arr.length && top2 > top1){
            top2--;
            arr[top2] =num;


        }else{
            System.out.println("Exceded limit");
        }

    }

    private void pop1(){
        if(top1!=-1){
            System.out.println(arr[top1]);
            arr[top1] =0;
            top1--;
        }else{
            System.out.println("Stack is empty");
        }

    }

    private void pop2(){
        if(top2!=arr.length){
            System.out.println(arr[top2]);

            arr[top2] =0;
            top2++;
        }else{
            System.out.println("Stack is empty");
        }

    }
}

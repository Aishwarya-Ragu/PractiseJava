package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack =new Stack<Integer>();
    int minNum;
    public static void main(String args[]){
        MinStack st = new MinStack();
        System.out.println(st.getMin());
        st.push(7);
        st.push(8);
        System.out.println(st.top());
        System.out.println(st.getMin());
    }
    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        else return -1;
    }

    public int getMin() {
        int minEle = Integer.MAX_VALUE;
        if(!stack.isEmpty()){
            int i =0;
            while(i<stack.size()){
                minEle = stack.get(i) < minEle ?stack.get(i):minEle;
                i++;
            }

        }
        return minEle;
    }

}

package stack;

import java.util.Stack;

public class EvaluationPostFixExpression {
    public static void main(String args[]){
        EvaluationPostFixExpression vp = new EvaluationPostFixExpression();
        System.out.println(vp.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i =0;i<tokens.length;i++){
            if(Character.isDigit(tokens[i].toCharArray()[0])){
                st.push(tokens[i]);
            }else{
                int item1 = Integer.parseInt(st.pop());
                int item2 = Integer.parseInt(st.pop());
                int res =0;
                switch(tokens[i]){
                    case "+":
                        res = item2 + item1;
                        break;
                    case "-":
                        res = item2 - item1;
                        break;
                    case "*":
                        res = item2 * item1;
                        break;
                    case "/":
                        res = item2 / item1;
                        break;

                }
                st.push(String.valueOf(res));
            }

        }
        if(!st.isEmpty())
            return Integer.parseInt(st.pop());
        return  0;
    }


}

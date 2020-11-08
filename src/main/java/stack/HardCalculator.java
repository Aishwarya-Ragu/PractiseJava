package stack;

import java.util.Stack;

public class HardCalculator {
    public static void main(String[] args){
        HardCalculator hc = new HardCalculator();
        int res = hc.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(res);
    }
    public int calculate(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty()){
                    if(st.peek()!='('){
                        sb.append(st.pop());
                    }else{
                        break;
                    }
                }
                st.pop();
                String newString = sb.toString();
                int res =0;
                for(int j = newString.length();j>=0;j++){
                    if(newString.charAt(i) == '+'){
                        res+=Integer.parseInt(st.pop().toString());

                    }

                }

            }else{
                st.push(s.charAt(i));
            }

        }
        return 0;

    }
}

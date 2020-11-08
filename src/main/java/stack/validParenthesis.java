package stack;

import java.util.Stack;

public class validParenthesis {
    Stack<Character> stack = new Stack<Character>();
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }else if(s.length() ==1) return false;

        else{
            int i =0;
            while(i<s.length()){
                if(s.charAt(i) == '(' ||s.charAt(i) == '['|| s.charAt(i) == '{'){
                    stack.push(s.charAt(i));
                }else if(s.charAt(i) == ')' ||s.charAt(i) == ']'|| s.charAt(i) == '}'){
                    switch(s.charAt(i)){
                        case')':
                            if(!stack.isEmpty() && '(' == stack.peek()){
                                stack.pop();
                            }else return false;
                            break;
                        case']':
                            if(!stack.isEmpty() && '[' == stack.peek()){
                                stack.pop();
                            }else return false;
                            break;
                        case'}':
                            if( !stack.isEmpty() &&'{' == stack.peek()){
                                stack.pop();
                            }else return false;
                            break;
                    }

                }
                i++;
            }
            if(stack.isEmpty()){
                return true;
            }
            else{
                return false;
            }

        }

    }
    public static void main(String args[]){
        validParenthesis vp = new validParenthesis();
        System.out.println(vp.isValid("){"));
    }
}

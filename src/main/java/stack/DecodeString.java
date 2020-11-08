package stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String args[]){
        DecodeString cg = new DecodeString();
        String clone = cg.decodeString("3[a2[c]]");
        System.out.println(clone);
    }

    public String decodeString(String s) {
        Stack<Object> stackChar = new Stack<Object>();
        StringBuilder decodeString = new StringBuilder();

        int i =0;
        while( i < s.length()){
            if(s.charAt(i)!=']'){
                stackChar.push(s.charAt(i));
            }else{
                StringBuilder sb = new StringBuilder();
                int eleNum = 0;
                while(!stackChar.isEmpty()){
                    Character ele = (Character)stackChar.pop();
                    if(ele == '['){
                        eleNum = Integer.parseInt(stackChar.pop().toString());
                        break;
                    }else{
                        sb.append(ele);
                    }
                }
                String revrese = sb.reverse().toString();
                while(eleNum>0){
                    int in =0;
                    while(in<revrese.length()){
                        stackChar.push(revrese.charAt(in));
                        in++;
                    }
                    eleNum--;
                }

            }
            i++;
        }
        while(!stackChar.isEmpty()){
            decodeString.append(stackChar.pop());
        }
        return decodeString.reverse().toString();

    }
}

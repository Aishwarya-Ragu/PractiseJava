package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simplifyPath {
    public static void main(String args[]){
        simplifyPath sp = new simplifyPath();
        System.out.println(sp.simplifyPath("/a//b////c/d//././/.."));  // /c


    }

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<String>();
        StringBuilder sbt = new StringBuilder();
        int i =0;
        boolean prevDot = false;
        while(i<path.length()){
            if(path.charAt(i) == '/' || path.charAt(i) == '.'){
                if(path.charAt(i) == '.'){
                    if(prevDot){
                        if(!st.isEmpty()) st.pop();
                        prevDot = false;
                    }else{
                        prevDot = true;
                    }
                }
                else{
                    prevDot = false;
                    if(sbt.length()>0){
                        st.push(sbt.toString());
                        sbt = new StringBuilder();
                    }
                }
            }else{
                sbt.append(path.charAt(i));
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();

        if(st.isEmpty())
            return "/";

        Stack<String> string = new Stack<String>();

        while(!st.isEmpty()){
            string.push(st.pop());
        }
        while(!string.isEmpty()){
            sb.append("/"+string.pop());
        }

        return sb.toString();


    }
}

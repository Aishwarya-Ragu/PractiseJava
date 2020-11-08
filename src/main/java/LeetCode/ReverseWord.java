package LeetCode;

import java.util.LinkedList;

public class ReverseWord {
    public static void main(String[] args) {
        ReverseWord rs = new ReverseWord();
        System.out.println(rs.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        String str[] = s.split(" ");
        LinkedList<String> ll = new LinkedList<>();
        for(int i =0 ; i< str.length ; i++){
            String st = str[i].trim();
            if(st!=null && st.length() > 0)
            ll.addFirst(st);
        }
        StringBuilder sb = new StringBuilder();
        for(String st: ll){
            sb.append(st);
            sb.append(" ");
        }
        return sb.toString().trim();



    }
}

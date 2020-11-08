package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringCompression {
    public static void main(String[] args) {
        char c[] = {'a','b','c','d','e','f','g','g','g','g','g','g','g','g','g','g','g','g','a','b','c'};
        StringCompression sc = new StringCompression();
        //System.out.println(sc.compress(c));
        System.out.println(sc.compressed(c));

    }

    private int compressed(char[] chars) {
        int start =0;
        int end =1;
        int len  = chars.length;
        int count =1;
        Stack<Integer> st = null;
        while(start<len && end<len){
            if(chars[start] == chars[end]){
                count++;
                end++;
            }else if(chars[start]!= chars[end] ){
                int num = count;
                st = new Stack<>();
                while(count!=1 && num>0){
                    int rem = num%10;
                    st.push(rem);
                    num = num/10;
                }
                while(!st.isEmpty()){
                    chars[++start] = (char) (st.pop()+'0');
                }
                chars[++start]= chars[end];
                count=1;
                end++;
            }else{
                start++;
                end++;
            }
        }
        int num = count;
        st = new Stack<>();
        while(count!=1 && num>0){
            int rem = num%10;
            st.push(rem);
            num = num/10;
        }
        while(!st.isEmpty()){
            chars[++start] = (char) (st.pop()+'0');
        }
        int sum=0;
        for(int i =0;i<=start;i++){
            sum++;
        }
        return sum;

    }

    public int compress(char[] chars) {
        int len = chars.length;
        List<String> listChar = new ArrayList<>();
        if(len < 0)
            return 0;
        else{
            char prev = chars[0];
            listChar.add(String.valueOf(chars[0]));
            int count = 1;
            for(int i =1; i<len ; i++){
                if(prev == chars[i]){
                    count++;
                }
                else{
                    listChar.add(String.valueOf(count));
                    listChar.add(String.valueOf(chars[i]));
                    count =1;
                }
                prev = chars[i];
            }
            listChar.add(String.valueOf(count));
        }
        return listChar.size();
    }


}

package TopInterviewQuestions.Medium.String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s ="";
        Map<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int maxLen =0;
        int start =0;
        int i =0,j=0;
        while(j<c.length){
            if(map.containsKey(c[j])){
                i = Math.max(map.get(c[j]),i);
            }
            int curLen = j-i+1;
            if(maxLen < curLen){
                maxLen = curLen;
                start = i;
            }
            map.put(c[j],j+1);
            j++;
        }
        System.out.println(s.substring(start,start+maxLen));
    }
}

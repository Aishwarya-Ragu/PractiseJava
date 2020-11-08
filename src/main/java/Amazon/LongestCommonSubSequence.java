package Amazon;

import java.util.Arrays;

public class LongestCommonSubSequence {
    public static void main(String args[]){
        String[] s ={"abcacnj","abcachji","hjiabc"};
        int len = s.length;
        String[] suffixArray = new String[21];
        int index =0;

        for(int i =0;i<len;i++){
            int stringLength = s[i].length();
            for(int j=0;j<stringLength;j++){
                suffixArray[index]= s[i].substring(j,stringLength);
                index++;
            }
        }
        Arrays.sort(suffixArray);
        String lcp ="";
        for(int i=0;i<suffixArray.length;i++){
            int j =i+1;
            if(j<suffixArray.length){
                String res = lcp(suffixArray[i],suffixArray[j]);
                if(res.length() > lcp.length()) lcp=res;
            }
        }
        System.out.println(lcp);


    }

    private static String lcp(String s, String s1) {
        int len = Math.min(s.length(),s1.length());
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=s1.charAt(i)){
                return s.substring(0,i);
            }
        }
        return s.substring(0,len);
    }
}

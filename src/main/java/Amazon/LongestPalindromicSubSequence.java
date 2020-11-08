package Amazon;

import sun.awt.X11.XSystemTrayPeer;

public class LongestPalindromicSubSequence {
    public static void main(String args[]){
        String s ="banana";
        int len = s.length();
        String[] suffixArray = new String[len];
        for(int i =0;i<len;i++){
            suffixArray[i] = s.substring(i,len);
        }
        String lps="";
        for(int i=0;i<len;i++){
            String res = lpsFunction(suffixArray[i]);
            if(res.length() > lps.length()) lps=res;
        }
        System.out.println(lps);

    }
    public static String lpsFunction(String s){
        StringBuilder sb = new StringBuilder(s);
        String reverseString = sb.reverse().toString();
        if(s.equalsIgnoreCase(reverseString)){
            return reverseString;
        }
        return "";
    }
}

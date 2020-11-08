package Amazon;

import java.util.Arrays;

public class LongestDuplicatedString {
    public static void main(String args[]){
        String s = "banana";
        //form suffix tree 0 ->banana , 1->anana , 2->nana, 3->ana,4->na,5->a
        int len = s.length();
        String[] suffixTree = new String[len];
        for(int i=0; i<len; i++){
            suffixTree[i] = s.substring(i,len);
        }
        //Sort suffix tree
        Arrays.sort(suffixTree);
        String lrs ="";
        for(int i=0;i<len;i++){
            int j= i+1;
            if(j<len){
                String res = lcp(suffixTree[i],suffixTree[j]);
                if(res.length() > lrs.length()) lrs=res;
            }
        }
        System.out.println(lrs);
    }

    private static String lcp(String s, String st) {
        int len = Math.min(s.length(),st.length());
        for (int i=0;i<len;i++){
            if(s.charAt(i) != st.charAt(i)){
                return s.substring(0,i);
            }
        }
        return s.substring(0,len);
    }

}

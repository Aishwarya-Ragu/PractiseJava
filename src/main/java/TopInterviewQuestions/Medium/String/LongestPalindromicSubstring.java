package TopInterviewQuestions.Medium.String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring ls= new LongestPalindromicSubstring();
        String s ="babad";
        if(s.length() <= 1) {
            System.out.println(s);
        }
        String longest = s.substring(0, 1);
        for(int i = 0; i < s.length(); i++) {
            String temp = ls.expandAroundCenter(s, i, i);
            if(temp.length() > longest.length()) {
                longest = temp;
            }
            temp = ls.expandAroundCenter(s, i, i + 1);
            if(temp.length() > longest.length()) {
                longest = temp;
            }
        }
        System.out.println(longest);
    }

    public String expandAroundCenter(String s,int left,int right){
        while(left>=0 && right<s.length()&& s.charAt(left) ==s.charAt(right)){
            left = left-1;
            right++;
        }
        return s.substring(left+1,right);
    }
}

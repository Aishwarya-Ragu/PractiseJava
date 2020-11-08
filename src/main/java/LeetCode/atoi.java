package LeetCode;

public class atoi {
    public static void main(String[] args) {
        atoi a = new atoi();
        System.out.println(a.myAtoi("91283472332"));
    }
    public int myAtoi(String str) {
        int res = 0;
        int sign = 1;
        str = str.trim();
        if(Character.isLetter(str.charAt(0)))
            return 0;
        for(int i =0; i<str.length();i++){
            if(str.charAt(i) == '-'){
                sign =-1;
            }
            if(Character.isDigit(str.charAt(i))){
                res = (res*10)+Integer.parseInt(String.valueOf(str.charAt(i)));
            }

        }
        int value = res*sign;
        if(value < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return value;
    }
}

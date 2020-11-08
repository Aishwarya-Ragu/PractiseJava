public class StringReversal {
    public static void main(String args[]){
        String str = "HelloWorld";
        int len = str.length();
        int mid = len/2;
        char c[] = str.toCharArray();
        int i=0;
        char[] reversedString= reverse(c,len,mid,i);
        System.out.println(String.valueOf(reversedString));
    }

    private static char[] reverse(char[] c, int len, int mid, int i) {
        if(i == mid){
            return c;
        }else{
            char temp = c[i];
            c[i] = c[len-1-i];
            c[len-1-i] = temp;
            return reverse(c,len,mid,i+1);
        }
    }
}

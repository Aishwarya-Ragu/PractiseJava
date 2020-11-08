package stack;

public class DecodedString {
    public static void main(String[] args) {
        DecodedString ds = new DecodedString();
        String s = ds.decodeAtIndex("ha22",5);
        System.out.println(s);

    }

    public String decodeAtIndex(String S, int K) {
        int i =0;
        StringBuilder sb = new StringBuilder();
        while(i<S.length()){
            if(Character.isDigit(S.charAt(i))){
                int ele = S.charAt(i) - '0';
                ele = ele-1;
                while(ele > 0){
                    sb.append(sb);
                    ele--;
                }
            }else if(sb.length() > K){
                return String.valueOf(sb.charAt(K-1));
            }else{
                sb.append(S.charAt(i));
            }
            i++;
        }
        return String.valueOf(sb.charAt(K-1));

    }
}

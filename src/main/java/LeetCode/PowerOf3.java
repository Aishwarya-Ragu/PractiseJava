package LeetCode;

public class PowerOf3 {
    public static void main(String[] args) {
        PowerOf3 po = new PowerOf3();
        System.out.println(po.isPowerOfThree(27));

    }

    public boolean isPowerOfThree(int n) {
        boolean isPower = false;
        while(n%3 ==0){
            n = n/3;
            isPower = true;
        }
        if(n == 1 && isPower){
            return true;
        }
        return false;

    }
}

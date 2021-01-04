package LeetCode;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        int primeCount = 0;

        for(int i = 2; i*i < n ;i++){
            if(isPrimes[i]){
                for(int j =i;i*j< n;j++){
                    isPrimes[i*j] = false;
                }
            }
        }

        for(int k =0;k<n;k++){
            if(isPrimes[k]){
                primeCount++;
            }
        }

        return primeCount-2;
    }
}

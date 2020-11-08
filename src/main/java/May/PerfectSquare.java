package May;

public class PerfectSquare {
    public static void main(String args[]){
        int n =37;
        int lsum=0;
        for(int i =1,sum=0;sum<n;i=i+2){
            sum+=i;
            lsum =sum;
        }
        if(lsum == n) System.out.println(true);
        else System.out.println(false);

    }
}

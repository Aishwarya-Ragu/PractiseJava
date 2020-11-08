package May;

public class DistanceBetweenOne {
    public static void main(String args[]){
        int [] num = {1,1,1,1};
        int k=0;
        System.out.println(checkNum(num,k));

    }

    private static boolean checkNum(int[] num, int k) {
        int length = num.length;
        boolean check =true;
        for(int i=0;i<length;i++){
            if(num[i] == 1){
                int startLen = i;
                int endLen =i+1;
                while(endLen<length && num[endLen]==0){
                    endLen++;
                }
                if(endLen-startLen-1>=k) check= true;
                else check= false;
                if (endLen == length-1) return check;
            }

        }
        return check;
    }
}

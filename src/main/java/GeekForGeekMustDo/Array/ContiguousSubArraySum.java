package GeekForGeekMustDo.Array;

public class ContiguousSubArraySum {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,7,5};
        int i= 0, j =1;
        int sum =0;
        int ts =19;
        boolean isSet = false;
        sum+=arr[0];
        while(i<arr.length && j<arr.length){
            if(sum< ts){
                sum+=arr[j];
                j++;
            } if(sum > ts){
                sum-=arr[i];
                i++;
            }
            if(sum == ts){
                isSet = true;
                System.out.println("Starting from index "+i +"to"+j);
                break;
            }
        }
        if(!isSet)
            System.out.println("Nothing to return so -1");

    }
}

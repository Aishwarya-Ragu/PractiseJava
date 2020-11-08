public class ArrayPair {
    public static void main(String args[]){
        int arr[] = {1,2,3,2,1,1,1};
        int i = 0;
        int j = i+1;
        int sum = 7;
        int resSum = 0;
        int n = arr.length;
        resSum = arr[i]+arr[j];
        while(i < n && j < n){
            if(resSum == sum){
                System.out.println("Set of array sum");
                for(int k=i;k<=j;k++){
                    System.out.println(arr[k]);
                }
                i=j;
                j++;
                resSum = 0;
                if(i < n && j < n)
                resSum = arr[i]+arr[j];
            }
            if(resSum > sum){
                i++;
                resSum = 0;
                if(i < n && j < n)
                resSum = arr[i]+arr[j];
            }
            if(resSum < sum){
                j++;
                if(j < n)
                resSum = resSum +arr[j];
            }
        }
    }
}

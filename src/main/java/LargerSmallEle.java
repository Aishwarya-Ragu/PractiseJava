public class LargerSmallEle {
    public static void main(String args[]){
        int arr[] = {13,67,89,23,1,12};
        int min=arr[0];
        int max=arr[0];
        for (int a: arr){
            if(a<min){
                min=a;
            }if(a>max){
                max=a;
            }
        }
        System.out.println(min);
        System.out.println(max);


    }
}

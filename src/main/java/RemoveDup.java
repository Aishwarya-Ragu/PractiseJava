import java.util.HashMap;
import java.util.Map;

public class RemoveDup {
    public static void main(String args[]){
        int arr[] = {1,2,3,2,5,6,7,9,10,17,20,1,3,4,5};
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        int j = 0;
        int i = 0;
        int len= arr.length-1;

        while(j < len){
            if(countMap.get(arr[j])!=null){
                int temp = arr[j];
                arr[j]=arr[j+1];
                j = i;
            }else{
                System.out.println(arr[j]);
                countMap.put(arr[j],1);
                j++;
                i++;
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class ArrayReverse {
    public static void main(String args[]){
        int[] array = {1,5,8,9,2,3};
        List<Integer> listArray = new ArrayList<Integer>();
        int len = array.length;
        int mid = len/2;
        for(int i = 0 ; i < mid ; i++){
            int temp = array[i];
            array[i] = array[len-1-i];
            array[len-1-i] = temp;
        }

        for(int i=0;i<len;i++){
            System.out.println(array[i]);
        }


    }
}

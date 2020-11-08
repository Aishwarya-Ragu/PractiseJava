package May;

public class SingleElementInSortedArray {
    public static void main(String args[]){
        int[] nums ={1,1,2,3,3,4,4,8,8};
        int i =0,j =0;
        int result=0;
        for(int num:nums){
            result^=num;
        }
        System.out.println(result);
    }
    }



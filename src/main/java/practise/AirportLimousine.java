package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportLimousine {

    static int count =0;

    public static void main(String[] args) {
        List<List<Integer>>mat = new ArrayList<>();
        mat.add(Arrays.asList(0,1,-1));
        mat.add(Arrays.asList(1,0,-1));
        mat.add(Arrays.asList(1,1,1));
        System.out.println(collectMax(mat));
    }

    public static int collectMax(List<List<Integer>> mat) {
        int row = mat.size();
        int col = mat.get(0).size();
        int i =0;
        int j =0;
        int onwardCount =  recurseList(mat,i,j,row,col,0, "onward");
        int returnCount =  recurseList(mat,row-1,col-1,row,col,0,"return");
        return  onwardCount+returnCount;
    }

    public static int recurseList(List<List<Integer>> mat,int i, int j,int row,int col,int riderCount,String flag){
        if(i<0 || j<0 || i >= row || j >= col || mat.get(i).get(j) == -1 || (i==0 && j==0 && flag== "return")){
            return riderCount;
        }
        if(mat.get(i).get(j) == 1) {
            riderCount++;
            mat.get(i).set(j, 0);
            if(i== row-1 && j == col-1){
                return riderCount;
            }
        }
        if(flag=="onward"){
             int rightCount = recurseList(mat,i,j+1,row,col,riderCount,"onward");
             int downCount = recurseList(mat,i+1,j,row,col,riderCount,"onward");
             return Math.max(rightCount,downCount);
        }
        if(flag=="return"){
            int leftRiderCount = recurseList(mat,i,j-1,row,col,riderCount,"return");
            int upRiderCount = recurseList(mat,i-1,j,row,col,riderCount,"return");
            return Math.max(leftRiderCount,upRiderCount);
        }
        return count;
    }

}


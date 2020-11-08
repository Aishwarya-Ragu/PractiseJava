package Blind75;

public class ContainerWithWater {
    public static void main(String args[]){
        int[] height ={1,1};
        int fli=0,sli=0;
        int fl =0,sl=0;
        for(int i =0;i<height.length;i++){
            if(height[i]>fl){
                sl =fl;
                sli =fli;
                fli =i;
                fl = height[i];
            }else if(height[i]> sl && height[i]!=fl){
                sl =height[i];
                sli =i;
            }

        }

        System.out.println(Math.abs(fli-sli) == 0 ? sl * 1:sl*Math.abs(fli-sli));


    }
}

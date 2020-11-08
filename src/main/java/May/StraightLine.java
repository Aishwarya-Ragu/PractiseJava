package May;

public class StraightLine {
    public static void main(String args[]){
        int[][] coordinates= {
                {-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2} };
        int slope = 0;
        int markedSlope =0;
        for(int i = 0 ; i < coordinates.length ; i++){
            int j = i+1;
            if(j < coordinates.length){
                slope = coordinates[j][1] - coordinates[i][1] / coordinates[j][0] - coordinates[i][0];
            }
            if(i ==0){
                markedSlope = slope;
            }else{
                if(slope == markedSlope) System.out.println(true);
                else System.out.println(false);
            }
        }
    }

    private float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

}

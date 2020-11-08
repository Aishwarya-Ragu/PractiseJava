package stack;

public class maximalRectangle {
    public static void main(String[] args) {
        maximalRectangle nge = new maximalRectangle();
        int a = nge.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
});
        System.out.println(a);
    }

    public int maximalRectangle(char[][] matrix) {
        int res =0;
        int intermediateRes =0;
        for(int i = 0; i < matrix.length;i++){
            int indexi = i+1;
            int j =0;
            while(indexi < matrix[i].length && j < matrix[i].length){
                if(matrix[i][j] == '1' && matrix[indexi][j] =='1'){
                    intermediateRes+=intermediateRes+2;
                }else{
                    res = Math.max(intermediateRes,res);
                    intermediateRes =0;
                }
                j++;

            }

        }

        return res;

    }
}

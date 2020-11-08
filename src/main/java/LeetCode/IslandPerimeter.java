package LeetCode;

public class IslandPerimeter {
    int[][] a ={{0,1,0,0,0},{1,1,1,0,0},{1,0,0,0,0}};


    public static void main(String[] args) {
        IslandPerimeter is = new IslandPerimeter();
        System.out.println(is.islandPerimeter(is.a));

    }
    public int islandPerimeter(int[][] grid) {
        int totalPerim = 0;
        int rlen = a.length;
        int clen = a[0].length;

        for(int i =0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    int perimeter =0;
                    perimeter = calculatePerimeter(i,j,perimeter,rlen,clen);
                    totalPerim+=perimeter;
                }
            }
        }
        return totalPerim;

    }

    public int calculatePerimeter(int row, int col, int peri,int rlen,int clen){
        if(row < 0 || row >= rlen || col < 0 || col >= clen){
             peri+=1;
            return peri;
        }
        else if(a[row][col] == 0){
            peri+=1;
            return peri;
        }else if(a[row][col] == 1){
            a[row][col] = -1;
        }else if(a[row][col] == -1){
            return peri;
        }
         return calculatePerimeter(row,col-1,peri,rlen,clen)+
         calculatePerimeter(row,col+1,peri,rlen,clen)+
         calculatePerimeter(row+1,col,peri,rlen,clen)+
         calculatePerimeter(row-1,col,peri,rlen,clen);

    }
}

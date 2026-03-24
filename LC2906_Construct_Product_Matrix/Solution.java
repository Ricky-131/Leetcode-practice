package LC2906_Construct_Product_Matrix;
import java.util.*;
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        long totmul = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res[i][j] = (int)totmul;
                totmul = (totmul * grid[i][j]) % 12345;
            }
        }
        totmul = 1;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                res[i][j] = (int)((res[i][j] * totmul) % 12345);
                totmul = (totmul * grid[i][j]) % 12345;
            }
        }
        return res;
    }
}
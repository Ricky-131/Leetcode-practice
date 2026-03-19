package LC3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y;
import java.util.*;
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] xcount = new int[m][n];
        int[][] prefmat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 'X'){
                    prefmat[i][j] = 1;
                    xcount[i][j] = 1;
                }
                if(grid[i][j] == 'Y')   prefmat[i][j] = -1;
                if(grid[i][j] == '.')   prefmat[i][j] = 0;
                
                if(i>0) prefmat[i][j] += prefmat[i-1][j];
                if(j>0) prefmat[i][j] += prefmat[i][j-1];
                if(i>0 && j>0)  prefmat[i][j] -= prefmat[i-1][j-1];
                
                if(i>0) xcount[i][j] += xcount[i-1][j];
                if(j>0) xcount[i][j] += xcount[i][j-1];
                if(i>0 && j>0)  xcount[i][j] -= xcount[i-1][j-1];
                
                if((prefmat[i][j] == 0) && xcount[i][j]>0)  count++;
            }
        }
        return count;
    }
}
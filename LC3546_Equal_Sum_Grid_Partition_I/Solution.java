package LC3546_Equal_Sum_Grid_Partition_I;
import java.util.*;
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totsum = 0;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                totsum += grid[i][j];
            }
        }
        if(totsum%2==1) return false;
        long halfsum = totsum/2;
        long horisum = 0;
        long vertisum = 0;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                horisum += grid[i][j];
            }
            if(horisum == halfsum)  return true;
            if(horisum > halfsum)   break;
        }
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                vertisum += grid[j][i];
            }
            if(vertisum == halfsum) return true;
            if(vertisum > halfsum)  break;
        }
        return false;
    }
}
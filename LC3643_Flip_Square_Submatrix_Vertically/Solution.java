package LC3643_Flip_Square_Submatrix_Vertically;
import java.util.*;
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=x; i<x+(k/2); i++){
            for(int j=y; j<y+k; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[x+k-1-(i-x)][j];
                grid[x+k-1-(i-x)][j] = temp;
            }
        }
        return grid;
    }
}
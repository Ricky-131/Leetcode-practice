package LC1727_Largest_Submatrix_With_Rearrangements;
import java.util.*;
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=1 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i-1][j];
            }
        }
        for (int i = 0; i<m; i++) {
            Arrays.sort(matrix[i]);
            for (int j=0; j<n; j++)
                res = Math.max(res, matrix[i][j] * (n - j));
        }
        return res;
    }
}
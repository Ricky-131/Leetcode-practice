package LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid;
import java.util.*;
class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int k = 0;
        for(int[] row : grid){
            for(int val : row) arr[k++] = val;
        }
        Arrays.sort(arr);
        int res = 0, median = arr[arr.length / 2];
        for(int val : arr){
            if((val - arr[0]) % x != 0) return -1;
            res += Math.abs(val - median) / x;
        }
        return res;
    }
}
package LC1536_Minimum_Swaps_to_Arrange_a_Binary_Grid;
import java.util.*;
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> zeros = new ArrayList<>();
        for (int[] row : grid){
            int count = 0;
            for (int j=n-1 ; j>=0 && row[j]==0 ; j--)
                count++;
            zeros.add(count);
        }
        int swaps = 0;
        for (int i = 0; i < n; i++){
            int j;
            for (j=0 ; j<zeros.size() ; j++)
                if (zeros.get(j) >= n-1-i) break;
            if (j==zeros.size()) return -1;
            swaps += j;
            zeros.remove(j);
        }
        return swaps;
    }
}
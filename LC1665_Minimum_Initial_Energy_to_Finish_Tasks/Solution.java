package LC1665_Minimum_Initial_Energy_to_Finish_Tasks;
import java.util.*;
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int res = 0;
        for(int i=0; i<tasks.length; i++) {
            res = Math.max(res + tasks[i][0], tasks[i][1]);
        }
        return res;
    }
}
package LC3633_Earliest_Finish_Time_for_Land_and_Water_Rides_I;
import java.util.*;
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length, m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int a = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
                int b = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];
                ans = Math.min(ans, Math.min(a, b));
            }
        }
        return ans;
    }
}

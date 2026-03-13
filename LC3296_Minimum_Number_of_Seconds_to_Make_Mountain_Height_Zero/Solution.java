package LC3296_Minimum_Number_of_Seconds_to_Make_Mountain_Height_Zero;
import java.util.*;
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        Arrays.sort(workerTimes);
        long lowTime = 0;
        long highTime = (long) 1e16; 
        long minRequiredTime = highTime;
        while (lowTime <= highTime) {
            long midTime = lowTime + (highTime - lowTime) / 2;
            long totalHeightReduced = 0;
            for (int baseTime : workerTimes) {
                long lowHeight = 0;
                long highHeight = mountainHeight;
                long maxWorkerHeight = 0;
                while (lowHeight <= highHeight) {
                    long midHeight = lowHeight + (highHeight - lowHeight) / 2;
                    long timeNeeded = (long) baseTime * midHeight * (midHeight + 1) / 2;
                    
                    if (timeNeeded <= midTime) {
                        maxWorkerHeight = midHeight;
                        lowHeight = midHeight + 1;
                    } else {
                        highHeight = midHeight - 1;
                    }
                }
                totalHeightReduced += maxWorkerHeight;
                if (totalHeightReduced >= mountainHeight) {
                    break;
                }
            }
            if (totalHeightReduced >= mountainHeight) {
                minRequiredTime = midTime;
                highTime = midTime - 1;
            } else {
                lowTime = midTime + 1;
            }
        }
        return minRequiredTime;
    }
}
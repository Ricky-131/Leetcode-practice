package LC1266_Minimum_Time_Visiting_All_Points;
import java.util.*;
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int n = points.length;
        for(int i=0 ; i<n-1 ; i++){
            int[] coord1 = points[i];
            int[] coord2 = points[i+1];
            int x1 = coord1[0];
            int y1 = coord1[1];
            int x2 = coord2[0];
            int y2 = coord2[1];
            int xdiff = Math.abs(x1-x2);
            int ydiff = Math.abs(y1-y2);
            int t = (xdiff>ydiff)?xdiff:ydiff;
            time+=t;
        }
        return time;
    }
}

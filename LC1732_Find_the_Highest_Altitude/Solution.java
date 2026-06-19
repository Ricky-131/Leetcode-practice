package LC1732_Find_the_Highest_Altitude;
import java.util.*;
class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int idx = 0;
        int max = 0;
        int[] arr = new int[n + 1];
        arr[idx++] = 0;
        for(int val : gain){
            arr[idx] = arr[idx - 1] + val;
            max = Math.max(max, arr[idx]);
            idx++;
        }
        return max;
    }
}


package LC2574_Left_and_Right_Sum_Differences;
import java.util.*;
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int sum = 0;
        int curr = 0;
        for(int i=0 ; i<n ; i++)    sum += nums[i];
        for(int i=0 ; i<n ; i++){
            curr += nums[i];
            res[i] = Math.abs(curr - sum);
            sum -= nums[i];
        }
        return res;
    }
}

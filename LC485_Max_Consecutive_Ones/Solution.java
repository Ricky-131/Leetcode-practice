package LC485_Max_Consecutive_Ones;
import java.util.*;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int ele : nums){
            if(ele == 1){
                count++;
            }
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}

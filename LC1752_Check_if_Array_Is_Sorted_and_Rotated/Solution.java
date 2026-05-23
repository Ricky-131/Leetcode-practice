package LC1752_Check_if_Array_Is_Sorted_and_Rotated;
import java.util.*;
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int dip = 0;
        for(int i=0 ; i<n-1 ; i++){
            if(nums[i] > nums[i+1])   dip++;
        }
        if(dip == 1)  return(nums[0] >= nums[n-1]);
        else return(dip == 0);
    }
}
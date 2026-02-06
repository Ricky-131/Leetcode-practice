package LC3634_Minimum_Removals_to_Balance_Array;
import java.util.*;
class Solution {
    public int minRemoval(int[] nums, int k) {
        int oppres = 0;
        int j=0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0 ; i<n ; i++){
            long limit = (long) nums[i]*k;
            for(; j<n && nums[j] <= limit ; j++);
            oppres = Math.max(oppres, j-i);
        }
        return n - oppres;
    }
}
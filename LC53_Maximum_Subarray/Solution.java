package LC53_Maximum_Subarray;
import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int msum = nums[0];
        int csum = msum;
        for(int i=1 ; i<nums.length ; i++){
            csum = Math.max(nums[i],csum+nums[i]);
            msum = (msum<csum)?csum:msum;
        }
        return msum;
    }
}

package LC3314_3315_Construct_the_Minimum_Bitwise_Array;
import java.util.*;
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            int val = nums.get(i);
            if (val == 2)
                ans[i] = -1; 
            else{
                int temp = val;
                int b = 0;
                while ((temp & 1) == 1) {
                    temp >>= 1;
                    b++;
                }
                ans[i] = val ^ (1 << (b - 1));
            }
        }
        return ans;
    }
}

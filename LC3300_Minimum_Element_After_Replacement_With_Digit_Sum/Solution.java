package LC3300_Minimum_Element_After_Replacement_With_Digit_Sum;
import java.util.*;
class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int num : nums){
            int digitsum = 0;
            while(num>0){
                digitsum += num%10;
                num /= 10;
            }
            res = Math.min(res, digitsum);
        }
        return res;
    }
}

package LC1979_Find_Greatest_Common_Divisor_of_Array;
import java.util.*;
class Solution {
    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return gcd(max, min);
    }
}

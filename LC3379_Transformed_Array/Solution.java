package LC3379_Transformed_Array;
import java.util.*;
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0; i<n ;i++){
            if(nums[i]!=0){
                res[i] = nums[((i+nums[i])%n + n)%n];
            }
            else{
                res[i] = nums[i];
            }
        }
        return res;
    }
}
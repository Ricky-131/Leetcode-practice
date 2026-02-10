package LC3719_Longest_Balanced_Subarray_I;
import java.util.*;
class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer> even = new HashSet<>();
        Set<Integer> odd = new HashSet<>();
        int longest = 0;
        for(int i=0 ; i<nums.length ; i++){
            int len = 0;
            for(int j=i ; j<nums.length ; j++){
                len++;
                if(nums[j]%2==0)    even.add(nums[j]);
                else    odd.add(nums[j]);
                if(even.size() == odd.size())   longest = Math.max(longest, len);
            }
            even.clear();
            odd.clear();
        }
        return longest;
    }
}
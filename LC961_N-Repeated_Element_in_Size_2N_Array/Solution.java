package LC961_N-Repeated_Element_in_Size_2N_Array;
import java.util.*;
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Set<Integer> newnums = new HashSet<>();
        for(int i=0 ; i<n*2 ; i++){
            if(newnums.contains(nums[i])){
                return nums[i];
            }
            newnums.add(nums[i]);
        }
        return -1;
    }
}

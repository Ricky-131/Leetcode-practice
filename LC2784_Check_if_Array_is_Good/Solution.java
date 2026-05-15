package LC2784_Check_if_Array_is_Good;
import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        boolean dupl = false;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(num > n) return false;
            if(set.contains(num)){
                if(num < n || dupl) return false;
                dupl = true;
                continue;
            }
            set.add(num);
        }
        return true;
    }
}
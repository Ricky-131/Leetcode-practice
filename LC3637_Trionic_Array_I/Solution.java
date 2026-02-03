package LC3637_Trionic_Array_I;
import java.util.*;
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n == 3) return false;
        int i = 0;
        for(;i < n - 1 && nums[i] < nums[i + 1] ; i++);
        if (i == 0 || i == n - 1) return false;
        int p = i;
        for(; i < n - 1 && nums[i] > nums[i + 1] ; i++);
        if (i == p || i == n - 1) return false;
        for(; i < n - 1 && nums[i] < nums[i + 1] ; i++);
        return i == n - 1;
    }
}
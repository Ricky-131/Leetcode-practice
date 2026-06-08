package LC2161_Partition_Array_According_to_Given_Pivot;
import java.util.*;
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = 0;
        int pcount = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pivot)     res[idx++] = nums[i];
            if(nums[i] == pivot)    pcount++;
        }
        for(int i = 0 ; i < pcount ; i++)   res[idx++] = pivot;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > pivot)    res[idx++] = nums[i];
        }
        return res;
    }
}

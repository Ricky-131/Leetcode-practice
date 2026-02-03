package LC283_Move_Zeroes;
import java.util.*;
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int ele : nums){
            if(ele!=0){
                nums[index++] = ele;
            }
        }
        while(index<nums.length){
            nums[index++] = 0;
        }
    }
}

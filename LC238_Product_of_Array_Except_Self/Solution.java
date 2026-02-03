package LC238_Product_of_Array_Except_Self;
import java.util.*;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
        int totmul = 1;
        boolean cond = true;
        int totnonzeromul = 1;
        int count = 0;
        for(int ele : nums){
            totmul*=ele;
            if(ele!=0){
                totnonzeromul *= ele;
                cond = false;
            }
            else{
                count++;
            }
        }
        if(totmul!=0){
            for(int i=0 ; i<nums.length ; i++){
                answer[i] = totmul/nums[i];
            }
        }
        else{
            for(int i=0 ; i<nums.length ; i++){
                if(nums[i] != 0){
                    answer[i] = 0;
                }
                else if(count>1){
                    answer[i] = nums[i];
                }
                else if(!cond){
                    answer[i] = totnonzeromul;
                }
            }
        }
        return answer;
    }
}

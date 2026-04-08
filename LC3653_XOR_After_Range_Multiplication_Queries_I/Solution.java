package LC3653_XOR_After_Range_Multiplication_Queries_I;
import java.util.*;
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries){
            int idx = query[0];
            while(idx <= query[1]){
                nums[idx] = (int) (((long) nums[idx] * query[3]) % 1000000007);
                idx += query[2];
            }
        }
        int res = nums[0];
        if(nums.length == 1)    return res;
        for(int i=1 ; i<nums.length ; i++){
            res ^= nums[i];
        }
        return res;
    }
}
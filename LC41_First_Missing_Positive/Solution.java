package LC41_First_Missing_Positive;
import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=1;
        boolean found = false;
        int ans=0;
        Map<Integer,Boolean> map = new HashMap<>();
        for(int ele : nums){
            if(ele<1){
                continue;
            }
            map.put(ele, true);
        }
        for(int j=1 ; j<=nums.length+1 ; j++){
            if(!map.containsKey(j)){
                return j;
            }
        }
        return -1;
    }
}

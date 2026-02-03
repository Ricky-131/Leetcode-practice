import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> l = new HashSet<>();
        int ind = 0;
        for(int ele : nums){
            if(!l.contains(ele)){
                nums[ind++] = ele;
                l.add(ele); 
            }
        }
        return ind;
    }
}

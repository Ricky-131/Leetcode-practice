package LC3740_Minimum_Distance_Between_Three_Equal_Elements_I;
import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        for(List<Integer> list : map.values()){
            for(int i=0; i<list.size()-2; i++){
                res = Math.min(res, (list.get(i+2) - list.get(i)) * 2);
            }
        }
        if(res == Integer.MAX_VALUE)    return -1;
        return res;
    }
}
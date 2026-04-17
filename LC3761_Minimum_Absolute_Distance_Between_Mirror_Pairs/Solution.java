package LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs;
import java.util.*;
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int res = n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            List<Integer> indices = map.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            map.put(nums[i], indices);
        }
        for(int i=0 ; i<n-1 ; i++){
            int revnum = 0;
            int temp = nums[i];
            while(temp>0){
                revnum = (revnum*10) + temp%10;
                temp/=10; 
            }
            List<Integer> indices = map.getOrDefault(revnum, new ArrayList<>());
            for(int j=0 ; j<indices.size() ; j++){
                if(indices.get(j) > i){
                    res = Math.min(res, indices.get(j)-i);
                    break;
                }
            }
            if(res == 1)    return 1;
        }
        return (res == n) ? -1 : res;
    }
}
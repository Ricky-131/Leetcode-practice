package LC1331_Rank_Transform_of_an_Array;
import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newarr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newarr);
        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : newarr){
            if (!map.containsKey(ele))  map.put(ele, rank++);
        }
        for(int i = 0; i < arr.length; i++) arr[i] = map.get(arr[i]);
        return arr;
    }
}

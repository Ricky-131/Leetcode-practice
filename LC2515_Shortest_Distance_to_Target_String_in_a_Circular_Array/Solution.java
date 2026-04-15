package LC2515_Shortest_Distance_to_Target_String_in_a_Circular_Array;
import java.util.*;
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(words[i].equals(target)){
                res = Math.min(res, Math.min((i - startIndex + n) % n, (startIndex - i + n) % n));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
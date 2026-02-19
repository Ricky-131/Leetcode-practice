package LC696_Count_Binary_Substrings;
import java.util.*;
class Solution {
    public int countBinarySubstrings(String s) {
        char[] carr = s.toCharArray();
        int n = carr.length;
        int count = 0;
        int prev = 0;
        int curr = 1;
        for(int i=1 ; i<n ; i++){
            if(carr[i] == carr[i-1])
                curr++;
            else{
                count += Math.min(prev,curr);
                prev = curr;
                curr = 1;
            }
        }
        count += Math.min(prev,curr);
        return count;
    }
}
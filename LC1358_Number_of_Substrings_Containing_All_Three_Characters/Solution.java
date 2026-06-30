package LC1358_Number_of_Substrings_Containing_All_Three_Characters;
import java.util.*;
class Solution {
    public int numberOfSubstrings(String s) {
        int total = 0;
        int a = -1;
        int b = -1;
        int c = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < s.length() ; i++){
            char ele = s.charAt(i);
            if(ele == 'a')      a = i;
            else if(ele == 'b') b = i;
            else                c=i;
            min = Math.min(a, Math.min(b, c));
            if(a > -1 && b > -1 && c > -1){
                total += (min + 1);
            }
        }
        return total;
    }
}

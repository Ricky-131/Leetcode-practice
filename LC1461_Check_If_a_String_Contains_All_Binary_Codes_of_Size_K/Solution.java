package LC1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K;
import java.util.*;
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i<=s.length()-k ; i++){
            set.add(s.substring(i, i+k));
        }
        return set.size() == Math.pow(2,k);
    }
}
package LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word;
import java.util.*;
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(String pattern : patterns){
            if(word.indexOf(pattern) != -1) res++;
        }
        return res;
    }
}

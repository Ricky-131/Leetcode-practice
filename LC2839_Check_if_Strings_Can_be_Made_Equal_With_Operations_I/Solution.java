package LC2839_Check_if_Strings_Can_be_Made_Equal_With_Operations_I;
import java.util.*;
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        for(int i=0 ; i<2 ; i++){
            if(!(((s1.charAt(i) == s2.charAt(i+2) && s1.charAt(i+2) == s2.charAt(i)) || (s1.charAt(i) == s2.charAt(i) && s1.charAt(i+2) == s2.charAt(i+2))))){
                return false;
            }
        }
        return true;
    }
}
import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "");
        char sarr[] = cleaned.toCharArray();
        for(int i=0 ; i<sarr.length/2 ; i++ ){
            if( Character.toLowerCase(sarr[i]) != Character.toLowerCase(sarr[sarr.length-1-i])){
                return false;
            }
        }
        return true;
    }
}

package LC2840_Check_if_Strings_Can_be_Made_Equal_With_Operations_II;
import java.util.*;
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] odd1 = new int[26];
        int[] odd2 = new int[26];
        int[] eve1 = new int[26];
        int[] eve2 = new int[26];
        for(int i=0 ; i<n ; i+=2){
            odd1[s1.charAt(i) - 'a']++;
            odd2[s2.charAt(i) - 'a']++;
        }
        for(int i=1 ; i<n ; i+=2){
            eve1[s1.charAt(i) - 'a']++;
            eve2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(odd1,odd2) && Arrays.equals(eve1,eve2))  return true;
        return false;
    }
}
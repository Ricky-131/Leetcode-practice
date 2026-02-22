package LC868_Binary_Gap;
import java.util.*;
class Solution {
    public int binaryGap(int n) {
        String bn = Integer.toBinaryString(n);
        int longest = 0;
        int counter = 0;
        boolean found = false;
        for(int i=0 ; i<bn.length() ; i++){
            if(bn.charAt(i) == '1' && found){
                longest = Math.max(longest, ++counter);
                counter=0;
            }
            else if(bn.charAt(i) == '0') counter++;
            else found = true;
        }
        return longest;
    }
}
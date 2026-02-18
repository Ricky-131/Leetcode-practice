package LC693_Binary_Number_with_Alternating_Bits;
import java.util.*;
class Solution {
    public boolean hasAlternatingBits(int n) {
        String ns = Integer.toBinaryString(n);
        boolean res = true;
        char prev = ns.charAt(0);
        for(int i=1 ; i<ns.length() ; i++){
            char curr = ns.charAt(i);
            if(curr == prev){
                return false;
            }
            prev = curr;
        }
        return res;
    }
}
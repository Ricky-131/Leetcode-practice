package LC1545_Find_Kth_Bit_in_Nth_Binary_String;
import java.util.*;
class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for(int i=2 ; i<=n ; i++){
            String prevrev = new StringBuilder(sb.toString()).reverse().toString();
            sb.append("1");
            for(int j=0 ; j<prevrev.length() ; j++){
                char bit = prevrev.charAt(j);
                if(bit=='0'){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
            }
        }
        return sb.charAt(k-1);
    }
}
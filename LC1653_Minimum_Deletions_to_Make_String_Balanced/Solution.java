package LC1653_Minimum_Deletions_to_Make_String_Balanced;
import java.util.*;
class Solution {
    public int minimumDeletions(String s) {
        int minres = Integer.MAX_VALUE;
        int acount = 0;
        int bcount = 0;
        char[] carr = s.toCharArray();
        for(int i=0 ; i<carr.length ; i++)
            if(carr[i] == 'a') acount++;
        for(int i=0 ; i<carr.length ; i++){
            minres = Math.min(minres, acount+bcount);
            if(carr[i] == 'b') bcount++;
            else acount--;
        }
        minres = Math.min(minres, acount+bcount);
        return minres;
    }
}
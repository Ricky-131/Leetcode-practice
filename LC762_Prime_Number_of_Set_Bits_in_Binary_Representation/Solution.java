package LC762_Prime_Number_of_Set_Bits_in_Binary_Representation;
import java.util.*;
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        int j;
        for(int i=left ; i<=right ; i++){
            int setcount = Integer.bitCount(i);
            if(setcount==1) continue;
            for( j=2 ; j<=Math.sqrt(setcount) ; j++){
                if(setcount%j==0) break;
            }
            if(j==(int)(Math.sqrt(setcount)+1)) count++;
        }
        return count;
    }
}
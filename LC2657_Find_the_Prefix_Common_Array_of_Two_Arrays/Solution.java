package LC2657_Find_the_Prefix_Common_Array_of_Two_Arrays;
import java.util.*;
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int count = 0;
        int[] res = new int[n];
        boolean[] seen = new boolean[n];
        for(int i=0 ; i<n ; i++){
            if(seen[A[i] - 1])  count++;
            else                seen[A[i] - 1] = true;
            if(seen[B[i] - 1])  count++;
            else                seen[B[i] - 1] = true;
            res[i] = count;
        }
        return res;
    }
}
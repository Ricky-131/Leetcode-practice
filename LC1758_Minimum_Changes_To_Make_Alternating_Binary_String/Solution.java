package LC1758_Minimum_Changes_To_Make_Alternating_Binary_String;
import java.util.*;
class Solution {
    public int minOperations(String s) {
        int count1 = 0;
        int count2 = 0;
        int slen = s.length();
        int[] arr1 = new int[slen];
        int[] arr2 = new int[slen];
        for(int i=0; i<slen ; i++){
            if(i%2==0){
                arr1[i] = 1;
                arr2[i] = 0;
            }
            else{
                arr1[i] = 0;
                arr2[i] = 1;
            }
        }
        for(int i=0 ; i<slen ; i++){
            if(s.charAt(i)-'0' != arr1[i])  count1++;
            if(s.charAt(i)-'0' != arr2[i])  count2++;
        }
        return Math.min(count1,count2);
    }
}
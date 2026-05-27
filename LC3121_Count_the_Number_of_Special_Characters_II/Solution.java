package LC3121_Count_the_Number_of_Special_Characters_II;
import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] l = new int[26];
        int[] u = new int[26];
        Arrays.fill(l, -1);
        Arrays.fill(u, -1);
        int n = word.length();
        for(int i=0 ; i<n ; i++){
            char a = word.charAt(i);
            if(Character.isLowerCase(a))    l[a - 'a'] = i ;
            else{
                int idx = a - 'A';
                if (u[idx] == -1)   u[idx] = i;
            }
        }
        int res = 0;
        for (int i=0 ; i<26 ; i++){
            if (l[i] != -1 && u[i] != -1 && l[i] < u[i])    res++ ;
        }
        return res;
    }
}
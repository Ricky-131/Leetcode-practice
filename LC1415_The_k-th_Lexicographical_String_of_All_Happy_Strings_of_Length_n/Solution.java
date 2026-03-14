package LC1415_The_k-th_Lexicographical_String_of_All_Happy_Strings_of_Length_n;
import java.util.*;
class Solution {
    public String getHappyString(int n, int k) {
        int total = 3*((int)Math.pow(2,n-1));
        if (k>total)    return "";
        StringBuilder sb = new StringBuilder();
        k--;
        int size = (int)Math.pow(2,n-1);
        char prev = (char)('a'+(k/size));
        sb.append(prev);
        k%=size;
        while (--n>0) {
            size >>= 1;
            char first = (prev=='a') ? 'b' : 'a';
            char second = (prev=='c') ? 'b' : 'c';
            prev = (k/size == 0) ? first : second;
            sb.append(prev);
            k%=size;
        }
        return sb.toString();
    }
}
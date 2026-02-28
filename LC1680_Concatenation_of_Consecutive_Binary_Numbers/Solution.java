package LC1680_Concatenation_of_Consecutive_Binary_Numbers;
import java.util.*;
class Solution {
    public int concatenatedBinary(int n) {
        long res = 0; 
        long power = 1;
        long mod = 1000000007;
        for (int i = n; i>=1; i--){
            String s = Integer.toBinaryString(i);
            for (int j = s.length()-1; j>=0; j--){
                if (s.charAt(j)=='1') res = (res+power) % mod;
                power = (power*2) % mod;
            }
        }
        return (int)res;
    }
}
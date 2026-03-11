package LC1009_Complement_of_Base_10_Integer;
import java.util.*;
class Solution {
    public int bitwiseComplement(int n) {
        return n^(int)(Math.pow(2, Integer.toBinaryString(n).length()) - 1);
    }
}
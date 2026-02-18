package LC191_Number_of_1_Bits;
import java.util.*;
class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
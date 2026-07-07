package LC3754_Concatenate_Non-Zero_Digits_and_Multiply_by_Sum_I;
import java.util.*;
class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        long pow = 1;
        for(int i = n % 10 ; n > 0 ; i = n % 10){
            if(i > 0){
                sum += i;
                num += i * pow;
                pow *= 10;
            }
            n /= 10;
        }
        return num * sum;
    }
}

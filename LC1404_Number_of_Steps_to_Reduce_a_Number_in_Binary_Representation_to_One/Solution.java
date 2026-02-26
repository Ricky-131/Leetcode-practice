package LC1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One;
import java.util.*;
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for (int i=s.length()-1; i>0; i--){
            if ((s.charAt(i)-'0')+carry == 1){
                steps += 2;
                carry = 1;
            } else {
                steps++;
            }
        }
        return steps+carry;
    }
}
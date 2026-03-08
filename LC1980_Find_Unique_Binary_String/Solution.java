package LC1980_Find_Unique_Binary_String;
import java.util.*;
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        for(int i=0; i<(1<<n) ; i++){
            if(!set.contains(i)){
                String binary = Integer.toBinaryString(i);
                while(binary.length()<n){
                    binary="0"+binary;
                }
                return binary;
            }
        }
        return "";
    }
}
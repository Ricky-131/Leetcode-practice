package LC1291_Sequential_Digits;
import java.util.*;
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String nums = "123456789";
        String l = String.valueOf(low);
        String h = String.valueOf(high);
        for(int len = l.length(); len <= h.length(); len++){
            for(int start = 0; start <= 9 - len; start++){
                int num = Integer.parseInt(nums.substring(start, start + len));
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        return res;
    }
}

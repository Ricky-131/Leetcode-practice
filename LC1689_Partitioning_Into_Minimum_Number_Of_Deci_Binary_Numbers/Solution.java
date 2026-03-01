package LC1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers;
import java.util.*;
class Solution {
    public int minPartitions(String n) {
        int count = 0;
        for(int i = 0; i<n.length(); i++){
            count = Math.max(count,n.charAt(i)-'0');
        }
        return count;
    }
}
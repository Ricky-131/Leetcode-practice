package LC1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones;
import java.util.*;
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
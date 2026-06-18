package LC1344_Angle_Between_Hands_of_a_Clock;
import java.util.*;
class Solution {
    public double angleClock(int hour, int minutes) {
        double angleh = (hour / 12.0) * 360 + (minutes / 60.0) * 30;
        double min = (minutes / 60.0) * 360;
        double angle = Math.abs(min - angleh);
        return Math.min(angle, 360 - angle);
    }
}

package LC2126_Destroying_Asteroids;
import java.util.*;
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long planet = mass;
        Arrays.sort(asteroids);
        for(int asteroid : asteroids){
            if(planet < asteroid) return false;
            planet += asteroid;
        }
        return true;
    }
}

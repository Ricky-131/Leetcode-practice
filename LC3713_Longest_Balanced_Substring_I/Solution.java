package LC3713_Longest_Balanced_Substring_I;
import java.util.*;
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int mx = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                mx = Math.max(mx, map.get(c));
                if (mx * map.size() == j - i + 1) 
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}
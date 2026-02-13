package LC3714_Longest_Balanced_Substring_II;
import java.util.*;
class Solution {
    public int longestBalanced(String s) {
        int maxlen = 0;
        maxlen = Math.max(maxlen, case1(s, 'a'));
        maxlen = Math.max(maxlen, case1(s, 'b'));
        maxlen = Math.max(maxlen, case1(s, 'c'));
        maxlen = Math.max(maxlen, case2(s, 'a', 'b', 'c'));
        maxlen = Math.max(maxlen, case2(s, 'a', 'c', 'b'));
        maxlen = Math.max(maxlen, case2(s, 'b', 'c', 'a'));
        maxlen = Math.max(maxlen, case3(s));
        return maxlen;
    }

    int case1(String s, char target) {
        int max = 0, current = 0;
        for (char c : s.toCharArray()) {
            if (c == target) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }
        return max;
    }

    int case2(String s, char c1, char c2, char forbidden) {
        int max = 0, bal = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == forbidden) {
                map = new HashMap<>();
                map.put(0, i);
                bal = 0;
            } 
            else {
                if (c == c1) bal++;
                else bal--; 
                if (map.containsKey(bal)) {
                    max = Math.max(max, i - map.get(bal));
                } else {
                    map.put(bal, i);
                }
            }
        }
        return max;
    }

    int case3(String s) {
        int max = 0;
        int ca = 0, cb = 0, cc = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') ca++;
            else if (c == 'b') cb++;
            else cc++;
            int d1 = ca - cb;
            int d2 = cb - cc;
            String key = d1 + "," + d2;
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}
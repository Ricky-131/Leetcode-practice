package LC1722_Minimize_Hamming_Distance_After_Swap_Operations;
import java.util.*;
class Solution {
    int[] p;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) p[pa] = pb;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length, res = 0;
        p = new int[n];
        for (int i=0; i<n; i++)
            p[i] = i;
        for (int[] s : allowedSwaps) 
            union(s[0], s[1]);
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int root = find(i);
            map.putIfAbsent(root, new HashMap<>());
            map.get(root).put(source[i], map.get(root).getOrDefault(source[i], 0) + 1);
        }
        for (int i=0; i<n; i++) {
            int root = find(i);
            Map<Integer, Integer> freq = map.get(root);
            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                res++;
            }
        }
        return res;
    }
}
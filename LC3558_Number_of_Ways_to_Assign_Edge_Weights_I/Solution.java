package LC3558_Number_of_Ways_to_Assign_Edge_Weights_I;
import java.util.*;
class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int maxD = 0, MOD = 1000000007;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e : edges){
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Map<Integer, Integer> depth = new HashMap<>();
        depth.put(1, 0);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.getOrDefault(u, new ArrayList<>())){
                if(!depth.containsKey(v)){
                    depth.put(v, depth.get(u) + 1);
                    q.offer(v);
                    maxD = Math.max(maxD, depth.get(v));
                }
            }
        }
        long res = 1;
        for(int i=0 ; i<maxD-1 ; i++)   res = (res * 2) % MOD;
        return (int) res;
    }
}

package LC3559_Number_of_Ways_to_Assign_Edge_Weights_II;
import java.util.*;
class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1, MOD = 1000000007, LOG = 18;
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for(int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[][] up = new int[n + 1][LOG];
        int[] depth = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        q.offer(1);
        vis[1] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : adj[u]) {
                if(!vis[v]) {
                    vis[v] = true;
                    depth[v] = depth[u] + 1;
                    up[v][0] = u;
                    q.offer(v);
                }
            }
        }
        for(int j=1; j<LOG; j++) {
            for(int i=1; i<=n; i++) {
                if(up[i][j-1] != 0) up[i][j] = up[up[i][j-1]][j-1];
            }
        }
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if(u == v) { res[i] = 0; continue; }
            if(depth[u] < depth[v]) { int t = u; u = v; v = t; }
            for(int j=LOG-1; j>=0; j--) if(depth[u] - (1 << j) >= depth[v]) u = up[u][j];
            if(u != v) {
                for(int j=LOG-1; j>=0; j--) {
                    if(up[u][j] != 0 && up[u][j] != up[v][j]) { u = up[u][j]; v = up[v][j]; }
                }
                u = up[u][0];
            }
            int d = depth[queries[i][0]] + depth[queries[i][1]] - 2 * depth[u];
            long pow = 1, base = 2;
            int exp = d - 1;
            while(exp > 0) {
                if(exp % 2 == 1) pow = (pow * base) % MOD;
                base = (base * base) % MOD;
                exp /= 2;
            }
            res[i] = (int) pow;
        }
        return res;
    }
}

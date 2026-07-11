package LC2685_Count_the_Number_of_Complete_Components;
import java.util.*;
class Solution {
    void dfs(int u, List<List<Integer>> adj, boolean[] vis, List<Integer> comp){
        vis[u] = true;
        comp.add(u);
        for(int v : adj.get(u))
            if(!vis[v]) dfs(v, adj, vis, comp);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)  adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                List<Integer> comp = new ArrayList<>();
                dfs(i, adj, vis, comp);
                boolean complete = true;
                for(int u : comp){
                    if(adj.get(u).size() != comp.size() - 1){
                        complete = false;
                        break;
                    }
                }
                if(complete)  ans++;
            }
        }
        return ans;
    }
}

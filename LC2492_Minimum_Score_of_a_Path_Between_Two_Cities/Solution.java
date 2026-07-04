package LC2492_Minimum_Score_of_a_Path_Between_Two_Cities;
import java.util.*;
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            int w = road[2];
            list.get(a).add(new int[]{b, w});
            list.get(b).add(new int[]{a, w});
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(1);
        visited[1] = true;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int a = q.poll();
            for(int[] edge : list.get(a)){
                int b = edge[0];
                int w = edge[1];
                min = Math.min(min, w);
                if(!visited[b]){
                    q.offer(b);
                    visited[b] = true;
                }
            }
        }
        return min;
    }
}

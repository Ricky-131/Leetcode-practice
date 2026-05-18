package LC1345_Jump_Game_IV;
import java.util.*;
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        int steps = 0;
        if(n == 1)  return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++)  map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int i = q.poll();
                if(i == n - 1)  return steps;
                if(i - 1 >= 0 && !vis[i - 1])   { vis[i - 1] = true; q.offer(i - 1); }
                if(i + 1 < n && !vis[i + 1])    { vis[i + 1] = true; q.offer(i + 1); }
                for(int nxt : map.get(arr[i])){
                    if(!vis[nxt])   { vis[nxt] = true; q.offer(nxt); }
                }
                map.get(arr[i]).clear();
            }
            steps++;
        }
        return -1;
    }
}
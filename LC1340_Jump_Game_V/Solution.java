package LC1340_Jump_Game_V;
import java.util.*;
class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int ans = 0;
        dp = new int[n];
        for(int i=0 ; i<n ; i++)  ans = Math.max(ans, dfs(arr, i, d, n));
        return ans;
    }
    
    private int dfs(int[] arr, int i, int d, int n){
        if(dp[i] != 0)  return dp[i];
        int res = 1;
        for(int j=i-1 ; j>=Math.max(0, i-d) && arr[i]>arr[j] ; j--) 
            res = Math.max(res, 1 + dfs(arr, j, d, n));
        for(int j=i+1 ; j<=Math.min(n-1, i+d) && arr[i]>arr[j] ; j++)   
            res = Math.max(res, 1 + dfs(arr, j, d, n));
        return dp[i] = res;
    }
}
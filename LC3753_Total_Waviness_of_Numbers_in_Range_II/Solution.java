package LC3753_Total_Waviness_of_Numbers_in_Range_II;
import java.util.*;
class Solution {
    long[][][][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if(num < 100) return 0;
        String s = Long.toString(num);
        dp = new long[s.length()][11][11][2][2][2];
        for(long[][][][][] a : dp) for(long[][][][] b : a) for(long[][][] c : b) for(long[][] d : c) for(long[] e : d) Arrays.fill(e, -1);
        return dfs(0, 10, 10, 1, 0, s)[1];
    }

    private long[] dfs(int i, int p, int p2, int lim, int st, String s) {
        if(i == s.length()) return new long[]{st, 0};
        if(dp[i][p][p2][lim][st][0] != -1) return dp[i][p][p2][lim][st];
        long n = 0, w = 0;
        int upper = lim == 1 ? s.charAt(i) - '0' : 9;
        for(int d=0; d<=upper; d++) {
            int nLim = (lim == 1 && d == upper) ? 1 : 0, nSt = (st == 1 || d > 0) ? 1 : 0;
            long[] nxt = dfs(i + 1, nSt == 1 ? d : 10, nSt == 1 ? p : 10, nLim, nSt, s);
            n += nxt[0];
            w += nxt[1];
            if(st == 1 && p != 10 && p2 != 10 && ((p > p2 && p > d) || (p < p2 && p < d))) w += nxt[0];
        }
        dp[i][p][p2][lim][st][0] = n;
        dp[i][p][p2][lim][st][1] = w;
        return dp[i][p][p2][lim][st];
    }
}

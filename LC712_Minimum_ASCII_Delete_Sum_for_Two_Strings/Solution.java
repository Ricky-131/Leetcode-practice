package LC712_Minimum_ASCII_Delete_Sum_for_Two_Strings;
import java.util.*;
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } 
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (char ele : s1.toCharArray()){
            sum1+=ele;
        }
        for (char ele : s2.toCharArray()){
            sum2+=ele;
        }
        return sum1 + sum2 - 2 * dp[m][n];
    }
}

package LC3418_Maximum_Amount_of_Money_Robot_Can_Earn;
import java.util.*;
class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int res = Integer.MIN_VALUE;
        int[][][] dp = new int[m][n][4];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    dp[i][j][k] = Integer.MIN_VALUE / 2;
                }
            }
        }
        dp[0][0][2] = coins[0][0];
        if(coins[0][0] < 0) dp[0][0][1] = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    if(i>0) dp[i][j][k] = Math.max(dp[i][j][k], Math.max(dp[i-1][j][k] + coins[i][j], dp[i-1][j][k+1]));
                    if(j>0) dp[i][j][k] = Math.max(dp[i][j][k], Math.max(dp[i][j-1][k] + coins[i][j], dp[i][j-1][k+1]));
                }
            }
        }
        for(int k=0; k<4; k++){
            res = Math.max(res, dp[m-1][n-1][k]);
        }
        return res;
    }
}
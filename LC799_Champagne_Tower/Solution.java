package LC799_Champagne_Tower;
import java.util.*;
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass){
        double[][] ctower = new double[101][101];
        ctower[0][0] = (double) poured;
        for (int r = 0; r <= query_row; r++){
            for (int c = 0; c<=r; c++) {
                if (ctower[r][c] > 1.0){
                    double excess = (ctower[r][c] - 1.0)/2.0;
                    ctower[r][c] = 1.0;
                    ctower[r + 1][c] += excess;
                    ctower[r + 1][c + 1] += excess;
                }
            }
        }
        return ctower[query_row][query_glass];
    }
}
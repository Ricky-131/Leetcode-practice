package LC2144_Minimum_Cost_of_Buying_Candies_With_Discount;
import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int count = 0;
        Arrays.sort(cost);
        for(int i=n-1 ; i>=0 ; i--){
            if((n - i) % 3 != 0){
                count += cost[i];
            }
        }
        return count;
    }
}

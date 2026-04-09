package LC3655_XOR_After_Range_Multiplication_Queries_II;
import java.util.*;
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int limit = (int)Math.sqrt(n) + 1;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] q : queries){
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if(k >= limit){
                for(int i=l; i<=r; i+=k){
                    nums[i] = (int)(((long)nums[i] * v) % 1000000007);
                }
            }
            else{
                map.computeIfAbsent(k, x -> new ArrayList<>()).add(q);
            }
        }
        for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
            int k = entry.getKey();
            long[] diff = new long[n];
            Arrays.fill(diff, 1L);
            for(int[] q : entry.getValue()){
                int l = q[0], r = q[1], v = q[3];
                diff[l] = (diff[l] * v) % 1000000007;
                int nxt = l + ((r - l) / k + 1) * k;
                if(nxt < n) diff[nxt] = (diff[nxt] * modInverse(v)) % 1000000007;
            }
            for(int i=0; i<n; i++){
                if(i >= k)  diff[i] = (diff[i] * diff[i-k]) % 1000000007;
                nums[i] = (int)(((long)nums[i] * diff[i]) % 1000000007);
            }
        }
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }

    private long modPow(long base, long exp) {
        long res = 1;
        while(exp > 0){
            if((exp & 1) == 1)  res = (res * base) % 1000000007;
            base = (base * base) % 1000000007;
            exp >>= 1;
        }
        return res;
    }

    private long modInverse(long x) {
        return modPow(x, 1000000005);
    }
}
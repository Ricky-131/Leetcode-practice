class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s+=s;
        int count1 = 0;
        int count2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<2*n ; i++){
            if (s.charAt(i)-'0' != i%2) count1++;
            if (s.charAt(i)-'0' != (i+1)%2) count2++;
            if (i>=n){
                if (s.charAt(i-n)-'0' != (i-n)%2)   count1--;
                if (s.charAt(i-n)-'0' != (i-n+1)%2) count2--;
            }
            if (i>=n-1){
                ans = Math.min(ans, Math.min(count1, count2));
            }
        }
        return ans;
    }
}
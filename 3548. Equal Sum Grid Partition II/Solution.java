class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totsum = 0;
        int[] topFreq = new int[100001];
        int[] botFreq = new int[100001];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                totsum += grid[i][j];
                botFreq[grid[i][j]]++;
            }
        }
        long topSum = 0;
        for(int i=0 ; i<m-1 ; i++){
            for(int j=0 ; j<n ; j++){
                int val = grid[i][j];
                topSum += val;
                topFreq[val]++;
                botFreq[val]--;
            }
            long botSum = totsum - topSum;
            long diff = topSum - botSum;
            if(diff == 0)   return true;
            if(diff > 0 && diff <= 100000 && topFreq[(int)diff] > 0){
                if(i == 0){
                    if(diff == grid[0][0] || diff == grid[0][n-1])  return true;
                }
                else if(n == 1){
                    if(diff == grid[0][0] || diff == grid[i][0])    return true;
                }
                else{
                    return true;
                }
            }
            else if(diff < 0 && -diff <= 100000 && botFreq[(int)-diff] > 0){
                long d = -diff;
                if(i == m-2){
                    if(d == grid[m-1][0] || d == grid[m-1][n-1])    return true;
                }
                else if(n == 1){
                    if(d == grid[i+1][0] || d == grid[m-1][0])  return true;
                }
                else{
                    return true;
                }
            }
        }
        int[] leftFreq = new int[100001];
        int[] rightFreq = new int[100001];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                rightFreq[grid[i][j]]++;
            }
        }
        long leftSum = 0;
        for(int j=0 ; j<n-1 ; j++){
            for(int i=0 ; i<m ; i++){
                int val = grid[i][j];
                leftSum += val;
                leftFreq[val]++;
                rightFreq[val]--;
            }
            long rightSum = totsum - leftSum;
            long diff = leftSum - rightSum;
            if(diff == 0)   return true;
            if(diff > 0 && diff <= 100000 && leftFreq[(int)diff] > 0){
                if(j == 0){
                    if(diff == grid[0][0] || diff == grid[m-1][0])  return true;
                }
                else if(m == 1){
                    if(diff == grid[0][0] || diff == grid[0][j])    return true;
                }
                else{
                    return true;
                }
            }
            else if(diff < 0 && -diff <= 100000 && rightFreq[(int)-diff] > 0){
                long d = -diff;
                if(j == n-2){
                    if(d == grid[0][n-1] || d == grid[m-1][n-1])    return true;
                }
                else if(m == 1){
                    if(d == grid[0][j+1] || d == grid[0][n-1])  return true;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}
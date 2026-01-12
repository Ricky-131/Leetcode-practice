class Solution {
    public int[] diff = {1,0,-1,0,1};
    public void dfs(int m, int n, int i, int j, char[][] grid, int[][] visitedgrid){
        visitedgrid[i][j] = 1;
        for(int k=0 ; k<4 ; k++){
            int ar = i+diff[k];
            int ac = j+diff[k+1];
            if(ar>=0 && ar<m && ac>=0 && ac<n && visitedgrid[ar][ac]!=1 && grid[ar][ac]=='1'){
                dfs(m,n,ar,ac,grid,visitedgrid);
            }
        }
    }


    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] visitedgrid = new int[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n; j++){
                if(grid[i][j] == '1' && visitedgrid[i][j]!=1){
                    count++;
                    dfs(m,n,i,j,grid,visitedgrid);
                }
            }
        }
        return count;
    }
}

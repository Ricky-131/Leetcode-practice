class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while(top < bottom && left < right){
            vector<int> layer;
            for(int i=left; i<=right; i++)      layer.push_back(grid[top][i]);
            for(int i=top+1; i<=bottom; i++)    layer.push_back(grid[i][right]);
            for(int i=right-1; i>=left; i--)    layer.push_back(grid[bottom][i]);
            for(int i=bottom-1; i>top; i--)     layer.push_back(grid[i][left]);
            
            int newk = k % layer.size();
            int idx = newk;
            for(int i=0; i<newk; i++)           layer.push_back(layer[i]);
            
            for(int i=left; i<=right; i++)      grid[top][i] = layer[idx++];
            for(int i=top+1; i<=bottom; i++)    grid[i][right] = layer[idx++];
            for(int i=right-1; i>=left; i--)    grid[bottom][i] = layer[idx++];
            for(int i=bottom-1; i>top; i--)     grid[i][left] = layer[idx++];
            
            top++; bottom--; left++; right--;
        }
        return grid;
    }
};
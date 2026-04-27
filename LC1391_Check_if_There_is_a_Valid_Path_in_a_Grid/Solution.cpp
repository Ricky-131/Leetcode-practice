#include <vector>
using namespace std;
class Solution {
    vector<vector<vector<int>>> dirs = {
        {}, 
        {{0, -1}, {0, 1}}, 
        {{-1, 0}, {1, 0}}, 
        {{0, -1}, {1, 0}}, 
        {{0, 1}, {1, 0}}, 
        {{0, -1}, {-1, 0}}, 
        {{-1, 0}, {0, 1}}
    };

    bool dfs(int x, int y, vector<vector<bool>>& vis, vector<vector<int>>& grid) {
        vis[x][y] = true;
        int m = grid.size();
        int n = grid[0].size();
        if(x == m-1 && y == n-1) return true;
        for(auto& d : dirs[grid[x][y]]) {
            int nx = x + d[0], ny = y + d[1];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                for(auto& nd : dirs[grid[nx][ny]]) {
                    if(nx + nd[0] == x && ny + nd[1] == y) {
                        if(dfs(nx, ny, vis, grid)) return true;
                        break;
                    }
                }
            }
        }
        return false;
    }

public:
    bool hasValidPath(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> vis(m, vector<bool>(n, false));
        return dfs(0, 0, vis, grid);
    }
};
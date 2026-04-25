#include <vector>
#include <algorithm>

using namespace std;

class Solution {
    bool check(int n, vector<long long>& res, long long lSide, int k) {
        int m = res.size();
        vector<int> idx(k);
        long long perimeter = lSide * 4;
        idx[0] = 0;
        for(int i=1; i<k; i++){
            auto it = lower_bound(res.begin(), res.end(), res[idx[i-1]] + n);
            if(it == res.end()) return false;
            idx[i] = distance(res.begin(), it);
        }
        if(res[idx[k-1]] - res[0] <= perimeter - n) return true;
        for(idx[0]=1; idx[0]<idx[1]; idx[0]++){
            for(int j=1; j<k; j++){
                while(idx[j] < m && res[idx[j]] < res[idx[j-1]] + n) idx[j]++;
                if(idx[j] == m) return false;
            }
            if(res[idx[k-1]] - res[idx[0]] <= perimeter - n) return true;
        }
        return false;
    }

public:
    int maxDistance(int side, vector<vector<int>>& points, int k) {
        int n = points.size();
        vector<long long> res(n);
        long long lSide = side;
        for(int i=0; i<n; i++){
            long long x = points[i][0], y = points[i][1];
            if(x == 0) res[i] = y;
            else if(y == lSide) res[i] = lSide + x;
            else if(x == lSide) res[i] = lSide * 3 - y;
            else res[i] = lSide * 4 - x;
        }
        sort(res.begin(), res.end());
        int left = 1, right = (lSide * 4) / k + 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(check(mid, res, lSide, k)) left = mid;
            else right = mid;
        }
        return left;
    }
};
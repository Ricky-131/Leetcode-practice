#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();
        int res = 0;
        int l = colors[0];
        int r = colors[n-1];
        for(int i=0 ; i<n ; i++){
            if(colors[i] != r){
                res = max(res, n-1-i);
                break;
            }
        }
        for(int i=n-1 ; i>=0 ; i--){
            if(colors[i] != l){
                res = max(res, i);
                break;
            }
        }
        return res;
    }
};
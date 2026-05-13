#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int minMoves(vector<int>& nums, int limit) {
        int n = nums.size();
        int current = n;
        int ans = INT_MAX;
        vector<int> diff(2 * limit + 2, 0);
        for(int i=0 ; i<n/2 ; i++){
            int a = min(nums[i], nums[n - 1 - i]);
            int b = max(nums[i], nums[n - 1 - i]);
            diff[a + 1]--;
            diff[b + limit + 1]++;
            diff[a + b]--;
            diff[a + b + 1]++;
        }
        for(int i=2 ; i<=2*limit ; i++){
            current += diff[i];
            ans = min(ans, current);
        }
        return ans;
    }
};
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        int n = nums.size(), sum = 0, total = 0;
        for(int x : nums) sum += x;
        for(int i=0; i<n; i++) total += nums[i] * i;
        int res = total;
        for(int i=1; i<n; i++) {
            total += sum - nums[n - i] * n;
            res = max(res, total);
        }
        return res;
    }
};
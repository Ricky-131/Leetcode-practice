#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<long long> distance(vector<int>& nums) {
        int n = nums.size();
        vector<long long> res(n, 0);
        unordered_map<int, long long> sum, cnt;
        for(int i=0; i<n; i++){
            res[i] += cnt[nums[i]] * i - sum[nums[i]];
            cnt[nums[i]]++;
            sum[nums[i]] += i;
        }
        sum.clear();
        cnt.clear();
        for(int i=n-1; i>=0; i--){
            res[i] += sum[nums[i]] - cnt[nums[i]] * i;
            cnt[nums[i]]++;
            sum[nums[i]] += i;
        }
        return res;
    }
};
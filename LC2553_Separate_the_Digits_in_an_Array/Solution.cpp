#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        vector<int> res;
        stack<int> stack;
        for(int num : nums){
            while(num > 0){
                stack.push(num % 10);
                num /= 10;
            }
            while(!stack.empty()){
                res.push_back(stack.top());
                stack.pop();
            }
        }
        return res;
    }
};
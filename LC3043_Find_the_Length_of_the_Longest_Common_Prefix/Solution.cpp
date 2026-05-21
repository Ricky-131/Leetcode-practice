#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    int longestCommonPrefix(vector<int>& arr1, vector<int>& arr2) {
        unordered_map<int, bool> map;
        for(int val : arr1){
            while(val > 0){
                map[val] = true;
                val /= 10;
            }
        }
        int res = 0;
        for(int val : arr2){
            while(val > 0){
                if(map[val]){
                    int num = val;
                    int len = 0;
                    while(num > 0){
                        len++;
                        num /= 10;
                    }
                    res = max(res, len);
                    break;
                }
                val /= 10;
            }
        }
        return res;
    }
};
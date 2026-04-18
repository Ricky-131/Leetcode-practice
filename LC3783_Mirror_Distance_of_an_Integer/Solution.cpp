#include <cstdlib>
class Solution {
public:
    int mirrorDistance(int n) {
        int revn = 0;
        int temp = n;
        while(temp > 0) {
            revn = revn * 10 + temp % 10;
            temp /= 10;
        }
        return abs(revn - n);
    }
};
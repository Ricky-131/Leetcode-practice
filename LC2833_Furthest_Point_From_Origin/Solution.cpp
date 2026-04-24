#include <string>
#include <cstdlib>

using namespace std;

class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int coord = 0;
        int space = 0;
        for(char move : moves){
            if(move == 'L') coord--;
            else if(move == 'R') coord++;
            else space++;
        }
        return abs(coord) + space;
    }
};
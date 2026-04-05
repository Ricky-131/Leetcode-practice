package LC657_Robot_Return_to_Origin;
import java.util.*;
class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if(n%2==1)  return false;
        int x = 0;
        int y = 0;
        for(char move : moves.toCharArray()){
            switch(move){
                case 'R':   x++; break;
                case 'L':   x--; break;
                case 'U':   y++; break;
                case 'D':   y--; break;
            }
        }
        return (x==0 && y==0);
    }
}
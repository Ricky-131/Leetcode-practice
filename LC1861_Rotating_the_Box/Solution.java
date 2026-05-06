package LC1861_Rotating_the_Box;
import java.util.*;
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] res = new char[n][m];
        for(int i=0 ; i<m ; i++){
            int curr = n - 1;
            for(int j=n-1 ; j>=0 ; j--){
                if(boxGrid[i][j] == '*'){
                    curr = j - 1;
                }
                else if(boxGrid[i][j] == '#'){
                    boxGrid[i][j] = '.';
                    boxGrid[i][curr] = '#';
                    curr--;
                }
            }
            for (int j=0; j<n; j++){
                res[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        return res;
    }
}
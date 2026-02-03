package LC994_Rotting_Oranges;
import java.util.*;
class Solution {
    private int[] diff = {1, 0 , -1, 0 , 1};
    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int oranges = 0;
        int minutes = 0;
        Queue<int[]> orgqueue = new LinkedList<>();
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                if(grid[i][j] != 0){
                    oranges++;
                    if(grid[i][j] == 2){
                        orgqueue.offer(new int[]{i,j,0});
                    }
                }
            }
        }
        while(!orgqueue.isEmpty()){
            int[] t = orgqueue.poll();
            int row = t[0];
            int col = t[1];
            int min = t[2];
            oranges--;
            minutes = min;
            for(int i=0 ; i<4 ; i++){
                int ar = row+diff[i];
                int ac = col+diff[i+1];
                if((ar>=0 && ac>=0 && ar<R && ac<C)){
                    if(grid[ar][ac] == 1){
                        grid[ar][ac] = 0;
                        orgqueue.offer(new int[]{ar, ac, min+1});
                    }
                }
            }
        }
        return (oranges==0)?minutes:-1;
    }
}

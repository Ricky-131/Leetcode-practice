package LC2069_Walking_Robot_Simulation_II;
import java.util.*;
class Robot {
    int x, y;
    int dir;
    int w, h;
    int total;
    public Robot(int width, int height) {
        x = 0;
        y = 0;
        dir = 1;
        w = width;
        h = height;
        total = 2 * w;
        total += 2 * (h - 2);
    }
    
    public void step(int num) {
        if(num % total == 0 && x == 0 && y == 0)    dir = 2;
        num %= total;
        while(num!=0){
            if(dir == 0){
                int step = h - y - 1;
                step = Math.min(step, num);
                y += step;
                num -= step;
            }
            else if(dir == 1){
                int step = w - x - 1;
                step = Math.min(step, num);
                x += step;
                num -= step;
            }
            else if(dir == 2){
                int step = Math.min(y, num);
                y -= step;
                num -= step;
            }
            else if(dir == 3){
                int step = Math.min(x, num);
                x -= step;
                num -= step;
            }
            if(num!=0) dir = (dir - 1 + 4) % 4;
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        if(dir == 0) return "North";
        if(dir == 1) return "East";
        if(dir == 2) return "South";
        return "West";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
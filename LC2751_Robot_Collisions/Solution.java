package LC2751_Robot_Collisions;
import java.util.*;
class Pair {
    int p, h, idx;
    char d;
    public Pair(int p, int h, char d, int idx) {
        this.p = p;
        this.h = h;
        this.d = d;
        this.idx = idx;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Pair> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Pair(positions[i], healths[i], directions.charAt(i), i));
        }
        list.sort((a, b) -> Integer.compare(a.p, b.p));
        Stack<Pair> st = new Stack<>();
        for(Pair curr : list){
            if(curr.d == 'R'){
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && curr.h > 0){
                    Pair top = st.peek();
                    if(top.h > curr.h){
                        top.h--;
                        curr.h = 0;
                        healths[top.idx] = top.h;
                        healths[curr.idx] = 0;
                    }
                    else if(top.h < curr.h){
                        curr.h--;
                        top.h = 0;
                        healths[curr.idx] = curr.h;
                        healths[top.idx] = 0;
                        st.pop();
                    }
                    else{
                        curr.h = 0;
                        top.h = 0;
                        healths[curr.idx] = 0;
                        healths[top.idx] = 0;
                        st.pop();
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int h : healths){
            if(h > 0)   res.add(h);
        }
        return res;
    }
}
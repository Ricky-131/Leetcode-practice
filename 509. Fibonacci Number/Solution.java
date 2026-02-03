import java.util.*;
class Solution {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int num=1;
        int a=0 , b=1;
        for(int i=2 ; i<=n ; i++){
            num = a+b;
            a=b;
            b=num;
        }
        return num;
    }
}

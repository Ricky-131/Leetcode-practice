import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp = x;
        int num = 0;
        for(int i=temp%10 ; temp>0 ; temp/=10 , i=temp%10){
            num = (num*10)+i;
        }
        return (x == num);
    }
}

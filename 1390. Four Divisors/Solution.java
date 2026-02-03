import java.util.*;
class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalsum = 0;
        for(int num : nums){
            int divcount = 0;
            int divsum = 0;
            for(int i = 1 ; i*i<=num ; i++){
                if(num%i == 0){
                    int fact1 = i;
                    int fact2 = num/i;
                    if(fact1 == fact2){
                        divcount++;
                        divsum+=fact1;
                    }
                    else{
                        divcount+=2;
                        divsum+=(fact1+fact2);
                    }
                }
                if(divcount>4){
                    break;
                }
            }
            if(divcount==4){
                totalsum+=divsum;
            }
        }
        return totalsum;
    }
}

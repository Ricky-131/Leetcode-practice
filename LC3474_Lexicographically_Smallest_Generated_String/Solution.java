package LC3474_Lexicographically_Smallest_Generated_String;
import java.util.*;
class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char res[] = new char[n+m-1];
        Arrays.fill(res, 'a');
        int used[] = new int[n+m-1];
        for(int i=0 ; i<n ; i++){
            if(str1.charAt(i) == 'T'){
                for(int j=i ; j<i+m ; j++){
                    if((used[j] == 1) && res[j] != str2.charAt(j-i))    return new String();
                    res[j] = str2.charAt(j-i);
                    used[j] = 1;
                }   
            }
        }
        for(int i=0 ; i<n ; i++){
            if(str1.charAt(i) == 'F'){
                boolean equal = true;
                for(int j=i ; j<i+m ; j++){
                    if(res[j] != str2.charAt(j-i)){
                        equal = false;
                        break;
                    }
                }
                if(equal){
                    for(int j=i+m-1 ; j>i-1 ; j--){
                        if(used[j] == 0){
                            res[j]++;
                            equal = false;
                            break;
                        }
                    }
                    if(equal)   return new String();
                }

            }
        }
        return new String(res);
    }
}
package LC1081_Smallest_Subsequence_of_Distinct_Characters;
import java.util.*;
class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        boolean[] vis = new boolean[26];
        int[] freq = new int[26];
        for(char ele : s.toCharArray()){
            freq[ele - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            char ele = s.charAt(i);
            if(!vis[ele - 'a']){
                while(sb.length() > 0 && sb.charAt(sb.length() - 1) > ele){
                    if(freq[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    else    break;
                }
                vis[ele - 'a'] = true;
                sb.append(ele);
            }
            freq[ele - 'a'] -= 1;
        }
        return sb.toString();
    }
}

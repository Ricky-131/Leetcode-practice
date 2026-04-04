package LC2075_Decode_the_Slanted_Ciphertext;
import java.util.*;
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1)    return encodedText;
        int n = encodedText.length();
        int column = n/rows;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<column ; i++){
            for(int j=i ; j<n ; j+=column+1){
                sb.append(encodedText.charAt(j));
                if(j % column == column - 1) break;
            }
        }
        return sb.toString().stripTrailing();
    }
}
package LC3120_Count_the_Number_of_Special_Characters_I;
import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char letter : word.toCharArray()) if(Character.isLowerCase(letter)) set.add(letter);
        for(char letter : word.toCharArray()){
            if(Character.isUpperCase(letter) && set.contains((char)(letter + 32))){
                count++;
                set.remove((char)(letter + 32));
            }
        }
        return count;
    }
}
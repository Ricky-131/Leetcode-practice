class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        String str = s.strip();
        char strarr[] = str.toCharArray();
        for(int i=strarr.length - 1 ; i>=0 ; i--){
            if(strarr[i] == ' '){
                break;
            }
            count++;
        }
        return count;
    }
}

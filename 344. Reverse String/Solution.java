class Solution {
    public void reverseString(char[] s) {
        int last = s.length - 1;
        for(int i=0 ; i<=last/2; i++){
            char temp = s[i];
            s[i] = s[last - i];
            s[last - i] = temp;
        }
    }
}

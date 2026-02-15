package LC67_Add_Binary;
import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(),b.length());
        int carry = 0;
        char[] A = new char[n];
        char[] B = new char[n];
        Arrays.fill(A, '0');
        Arrays.fill(B, '0');
        for (int i = a.length() - 1, j = n - 1; i >= 0; i--, j--) 
            A[j] = a.charAt(i);
        for (int i = b.length() - 1, j = n - 1; i >= 0; i--, j--) 
            B[j] = b.charAt(i);
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i>=0; i--){
            int sum = (A[i]-'0')+(B[i] - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry>0) 
            sb.append(1);
        return sb.reverse().toString();
    }
}
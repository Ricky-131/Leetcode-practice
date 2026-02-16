package LC190_Reverse_Bits;
import java.util.*;
class Solution {
    public int reverseBits(int n) {
        String ns = Integer.toBinaryString(n);
        int nlen = ns.length();
        int pluszeros = 32-nlen;
        StringBuilder sb = new StringBuilder(ns);
        sb.reverse();
        for(int i=0 ; i<pluszeros ; i++){
            sb.append("0");
        }
        String rns = sb.toString();
        int rn = Integer.parseInt(rns, 2);
        return rn;
    }
}

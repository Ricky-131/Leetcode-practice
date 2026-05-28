package LC3093_Longest_Common_Suffix_Queries;
import java.util.*;
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestLen = Integer.MAX_VALUE, bestIdx = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        for(int i=0; i<wordsContainer.length; i++) {
            String w = wordsContainer[i];
            int len = w.length();
            TrieNode curr = root;
            if(len < curr.bestLen || (len == curr.bestLen && i < curr.bestIdx)) { curr.bestLen = len; curr.bestIdx = i; }
            for(int j=len-1; j>=0; j--) {
                int c = w.charAt(j) - 'a';
                if(curr.children[c] == null) curr.children[c] = new TrieNode();
                curr = curr.children[c];
                if(len < curr.bestLen || (len == curr.bestLen && i < curr.bestIdx)) { curr.bestLen = len; curr.bestIdx = i; }
            }
        }
        int[] ans = new int[wordsQuery.length];
        for(int i=0; i<wordsQuery.length; i++) {
            String q = wordsQuery[i];
            TrieNode curr = root;
            for(int j=q.length()-1; j>=0; j--) {
                int c = q.charAt(j) - 'a';
                if(curr.children[c] == null) break;
                curr = curr.children[c];
            }
            ans[i] = curr.bestIdx;
        }
        return ans;
    }
}

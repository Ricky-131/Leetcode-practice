package LC61_Rotate_List;
import java.util.*;
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int n = 1;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
            n++;
        }
        k %= n;
        if(k == 0)  return head;
        curr.next = head;
        for(int i=0; i<n-k; i++)    curr = curr.next;
        ListNode res = curr.next;
        curr.next = null;
        return res;
    }
}
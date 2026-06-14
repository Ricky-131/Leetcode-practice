package LC2130_Maximum_Twin_Sum_of_a_Linked_List;
import java.util.*;
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int left=0;
        int right=list.size()-1;
        int max=Integer.MIN_VALUE;
        while(left < right){
            int curSum = list.get(left++) + list.get(right--);
            if(curSum > max)    max=curSum;
        }
        return max;
    }
}

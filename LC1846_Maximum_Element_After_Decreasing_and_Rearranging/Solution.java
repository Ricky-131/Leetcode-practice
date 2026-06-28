package LC1846_Maximum_Element_After_Decreasing_and_Rearranging;
import java.util.*;
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1 ; i < n ; i++){
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[n - 1];
    }
}

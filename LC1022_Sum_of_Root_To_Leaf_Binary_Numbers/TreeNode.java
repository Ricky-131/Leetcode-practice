package LC1022_Sum_of_Root_To_Leaf_Binary_Numbers;
import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        java.util.Stack<TreeNode> stk = new java.util.Stack<>();
        java.util.Stack<String> bin = new java.util.Stack<>();
        stk.push(root);
        bin.push(String.valueOf(root.val));
        int sum = 0;
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            String val = bin.pop();
            if (curr.left == null && curr.right == null) {
                sum += Integer.parseInt(val, 2);
            }
            if (curr.right != null) {
                stk.push(curr.right);
                bin.push(val + curr.right.val);
            }
            if (curr.left != null) {
                stk.push(curr.left);
                bin.push(val + curr.left.val);
            }
        }
        return sum;
    }
}
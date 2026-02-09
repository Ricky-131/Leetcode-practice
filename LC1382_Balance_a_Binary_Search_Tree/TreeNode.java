package LC1382_Balance_a_Binary_Search_Tree;
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
    List<Integer> sortedNodes = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildTree(0, sortedNodes.size()-1);
    }

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        sortedNodes.add(node.val);
        inorder(node.right);
    }

    TreeNode buildTree(int start, int end) {
        if (start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(sortedNodes.get(mid));
        node.left = buildTree(start, mid - 1);
        node.right = buildTree(mid + 1, end);
        return node;
    }
}
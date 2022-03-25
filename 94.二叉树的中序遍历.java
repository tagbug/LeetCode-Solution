import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// Definition for a binary tree node.
class TreeNode {
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

// @lc code=start
class Solution {
    private ArrayList<Integer> res = new ArrayList<>();
    
    private void inorder(TreeNode node) {
        if (node.left != null) {
            inorder(node.left);
        }
        res.add(node.val);
        if (node.right != null) {
            inorder(node.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        inorder(root);
        return res;
    }
}
// @lc code=end


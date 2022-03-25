/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// @lc code=start
class Solution {
    public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        TreeNode left = LCA(root.left, node1, node2);
        TreeNode right = LCA(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        return LCA(root, p, q);
    }
}
// @lc code=end

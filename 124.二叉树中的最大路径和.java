/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @lc code=start
class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int getSideMax(TreeNode node) {
        if (node.left == null && node.right == null) {
            maxSum = Math.max(maxSum, node.val);
            return node.val;
        }
        int left = 0, right = 0;
        if (node.left == null) {
            right = getSideMax(node.right);
            maxSum = Math.max(maxSum, node.val + (right < 0 ? 0 : right));
            return node.val + (right < 0 ? 0 : right);
        }
        if (node.right == null) {
            left = getSideMax(node.left);
            maxSum = Math.max(maxSum, node.val + (left < 0 ? 0 : left));
            return node.val + (left < 0 ? 0 : left);
        }
        left = getSideMax(node.left);
        right = getSideMax(node.right);
        maxSum = Math.max(maxSum, node.val + (left < 0 ? 0 : left) + (right < 0 ? 0 : right));
        int sideMax = Math.max(left, right);
        return Math.max(node.val, node.val + (sideMax < 0 ? 0 : sideMax));
    }

    public int maxPathSum(TreeNode root) {
        int sideMax = getSideMax(root);
        return Math.max(maxSum, sideMax);
    }
}
// @lc code=end

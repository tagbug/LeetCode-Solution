/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start

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

class Solution {
    public int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }
}
// @lc code=end

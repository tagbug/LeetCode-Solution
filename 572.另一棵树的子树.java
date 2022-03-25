/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    private boolean exactDfs(TreeNode node, TreeNode subNode) {
        if (node == subNode) {
            return true;
        }
        if (node != null && subNode != null && node.val == subNode.val) {
            return exactDfs(node.left, subNode.left) && exactDfs(node.right, subNode.right);
        }
        return false;
    }

    private boolean dfs(TreeNode node, TreeNode subNode) {
        if (node == null) {
            return false;
        }
        if (node.val == subNode.val) {
            return exactDfs(node, subNode) || dfs(node.left, subNode) || dfs(node.right, subNode);
        }
        return dfs(node.left, subNode) || dfs(node.right, subNode);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }
}
// @lc code=end

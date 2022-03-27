import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    @SuppressWarnings("unchecked")
    // dp[0]: 不选中的最大值 dp[1]: 选中的最大值
    private HashMap<TreeNode, Integer>[] dp = new HashMap[] { new HashMap<>(), new HashMap<>() };

    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        search(node.right);
        dp[0].put(node, Math.max(dp[0].getOrDefault(node.left, 0), dp[1].getOrDefault(node.left, 0))
                + Math.max(dp[0].getOrDefault(node.right, 0), dp[1].getOrDefault(node.right, 0)));
        dp[1].put(node, node.val + dp[0].getOrDefault(node.left, 0) + dp[0].getOrDefault(node.right, 0));
    }

    public int rob(TreeNode root) {
        search(root);
        return Math.max(dp[0].getOrDefault(root, 0), dp[1].getOrDefault(root, 0));
    }
}
// @lc code=end

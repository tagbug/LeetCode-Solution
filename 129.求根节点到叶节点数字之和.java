import java.util.Stack;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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
    private Stack<Integer> stack = new Stack<>();
    private int sum;

    private int convert() {
        Integer[] arr = stack.toArray(Integer[]::new);
        int num = 0;
        for (int i = arr.length - 1, radix = 1; i >= 0; i--, radix *= 10) {
            num += radix * arr[i];
        }
        return num;
    }

    private void dfs(TreeNode node) {
        stack.push(node.val);
        if (node.left == null && node.right == null) {
            // 累加结果
            sum += convert();
            stack.pop();
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        stack.pop();
    }

    public int sumNumbers(TreeNode root) {
        dfs(root);
        return sum;
    }
}
// @lc code=end

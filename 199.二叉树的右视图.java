import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        LinkedTransferQueue<TreeNode> queue = new LinkedTransferQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        int nextLeft = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int left = nextLeft;
            nextLeft = 0;
            for (int i = 0; i < left; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    nextLeft++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLeft++;
                }
                if (i == left - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
// @lc code=end

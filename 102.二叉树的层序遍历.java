import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedTransferQueue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.add(root);
        int left = 0, nextLeft = 1;
        while (nextLeft != 0) {
            ArrayList<Integer> list = new ArrayList<>();
            left = nextLeft;
            nextLeft = 0;
            while (left != 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    nextLeft++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLeft++;
                }
                left--;
            }
            res.add(list);
        }
        return res;
    }
}
// @lc code=end

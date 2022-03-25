import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedBlockingDeque<TreeNode> deque = new LinkedBlockingDeque<>();
        int left = 0, nextLeft = 1;
        deque.add(root);
        boolean reverse = false;
        while (nextLeft != 0) {
            left = nextLeft;
            nextLeft = 0;
            ArrayList<Integer> list = new ArrayList<>();
            if (reverse) {
                // 右到左
                while (left > 0) {
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        deque.addFirst(node.right);
                        nextLeft++;
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                        nextLeft++;
                    }
                    left--;
                }
            } else {
                // 左到右
                while (left > 0) {
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                        nextLeft++;
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                        nextLeft++;
                    }
                    left--;
                }
            }
            res.add(list);
            reverse = !reverse;
        }
        return res;
    }
}
// @lc code=end

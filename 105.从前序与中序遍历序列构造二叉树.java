/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private int[] preorder;
    private int[] inorder;
    private int root = 0;

    public int find(int val, int start, int end) throws Exception {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        throw new Exception("Not Found: " + val + " " + start + " " + end);
    }

    public TreeNode build(int start, int end) throws Exception {
        int val = preorder[root];
        int mid = find(val, start, end);
        TreeNode node = new TreeNode(val);
        // left
        if (mid > start) {
            root++;
            node.left = build(start, mid - 1);
        }
        // right
        if (mid < end) {
            root++;
            node.right = build(mid + 1, end);
        }
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        try {
            return build(0, preorder.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start

//  Definition for a binary tree node.
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
    public void singleMerge(int ori, ArrayList<TreeNode> list, ArrayList<TreeNode> left, ArrayList<TreeNode> right) {
        for (TreeNode leftNode : left) {
            TreeNode oriNode = new TreeNode(ori);
            oriNode.left = leftNode;
            list.add(oriNode);
        }
        for (TreeNode rightNode : right) {
            TreeNode oriNode = new TreeNode(ori);
            oriNode.right = rightNode;
            list.add(oriNode);
        }
    }

    public void merge(int ori, ArrayList<TreeNode> list, ArrayList<TreeNode> left, ArrayList<TreeNode> right) {
        for (TreeNode leftNode : left) {
            for (TreeNode rightNode : right) {
                TreeNode oriNode = new TreeNode(ori);
                oriNode.left = leftNode;
                oriNode.right = rightNode;
                list.add(oriNode);
            }
        }
    }

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[][] dp = new ArrayList[n + 1][n + 1];

        // 初始情况
        for (int i = 1; i <= n; i++) {
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(i));
            dp[i][i] = list;
        }

        // 从区间 width = 2 开始dp
        for (int width = 2; width <= n; width++) {
            for (int i = 1; i <= n - width + 1; i++) {
                int j = i + width - 1;
                ArrayList<TreeNode> list = new ArrayList<>();
                singleMerge(i, list, new ArrayList<>(), dp[i + 1][j]);
                singleMerge(j, list, dp[i][j - 1], new ArrayList<>());
                for (int k = 0; i + 2 + k <= j; k++) {
                    merge(i + k + 1, list, dp[i][i + k], dp[i + k + 2][j]);
                }
                dp[i][j] = list;
            }
        }

        return dp[1][n];
    }
}
// @lc code=end

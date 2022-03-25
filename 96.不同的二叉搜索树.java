/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];

        // 初始情况
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        // 从区间 width = 2 开始dp
        for (int width = 2; width <= n; width++) {
            for (int i = 1; i <= n - width + 1; i++) {
                int j = i + width - 1;
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1];
                for (int k = 0; i + 2 + k <= j; k++) {
                    dp[i][j] += dp[i][i + k] * dp[i + k + 2][j];
                }
            }
        }

        return dp[1][n];
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {
    /* public int getMinMax(int low, int high) {
        if (low == high) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int left = 0, right = 0;
            if (i > low) {
                left = getMinMax(low, i - 1);
            }
            if (i < high) {
                right = getMinMax(i + 1, high);
            }
            min = Math.min(min, Math.max(left + i, right + i));
        }
        return min;
    } */

    public int getMoneyAmount(int n) {
        // dp[i][j]：getMinMax(i,j)
        int[][] dp = new int[n + 1][n + 1];

        // 初态
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }

        // 区间dp
        for (int width = 2; width <= n; width++) {
            for (int i = 1; i + width - 1 <= n; i++) {
                int j = i + width - 1;
                // 区间[i, j]的所有情况取MinMax => line 14~23
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = 0, right = 0;
                    if (k > i) {
                        left = dp[i][k - 1];
                    }
                    if (k < j) {
                        right = dp[k + 1][j];
                    }
                    min = Math.min(min, Math.max(left + k, right + k));
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n];
    }
}
// @lc code=end

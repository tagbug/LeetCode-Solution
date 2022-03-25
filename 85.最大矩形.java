/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];
        int maxSize = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    // 第 0 列
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : dp[i][j - 1] + 1;
                }
                int minWidth = dp[i][j];
                for (int k = 1; i - k + 1 >= 0; k++) {
                    minWidth = Math.min(minWidth, dp[i - k + 1][j]);
                    maxSize = Math.max(maxSize, minWidth * k);
                }
            }
        }

        return maxSize;
    }
}
// @lc code=end

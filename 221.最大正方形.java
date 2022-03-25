/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxValue = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int sonMin = 0;
                if (i != 0 && j != 0) {
                    int parentMatrix = dp[i - 1][j - 1];
                    // son(min) = parent - 1
                    if (parentMatrix != 0) {
                        sonMin = parentMatrix - 1;
                    }
                }
                // 探测是否能组成更大的矩阵
                int maxRange = Math.min(dp.length - i, dp[0].length - j) - 1;
                int maxAdd = 0;
                boolean broken = false;
                for (int range = sonMin; range <= maxRange; range++) {
                    for (int i2 = i; i2 < i + range; i2++) {
                        if (matrix[i2][j + range] == '0') {
                            broken = true;
                            break;
                        }
                    }
                    if (broken) {
                        break;
                    }
                    for (int j2 = j; j2 <= j + range; j2++) {
                        if (matrix[i + range][j2] == '0') {
                            broken = true;
                            break;
                        }
                    }
                    if (broken) {
                        break;
                    }
                    maxAdd++;
                }
                dp[i][j] = sonMin + maxAdd;
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue * maxValue;
    }
}
// @lc code=end

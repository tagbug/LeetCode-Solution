/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 状态定义
        // dp[i][j]：表示 1串前i个字符 与 2串前j个字符 的最长公共子序列长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 初始状态
        /* dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0; */
        
        // 循环计算
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 返回结果
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end

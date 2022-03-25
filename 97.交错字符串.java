/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // 边界情况
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                    continue;
                }
                if (i > 0) {
                    dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
// @lc code=end

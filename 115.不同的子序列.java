/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // 初始态
        dp[0][0] = 1;

        // 边界状态
        for (int j = 1; j <= s.length(); j++) {
            dp[1][j] = dp[1][j - 1] + (t.charAt(0) == s.charAt(j - 1) ? 1 : 0);
        }

        for (int i = 2; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                boolean charFlag = t.charAt(i - 1) == s.charAt(j - 1);
                dp[i][j] = (charFlag ? dp[i - 1][j - 1] : 0) + dp[i][j - 1];
            }
        }

        return dp[t.length()][s.length()];
    }
}
// @lc code=end

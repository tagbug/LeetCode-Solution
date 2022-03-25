/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[Math.max(11, n + 1)];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        dp[7] = 12;
        dp[8] = 18;
        dp[9] = 27;
        dp[10] = 36;

        for (int i = 11; i <= n; i++) {
            int half = i / 2;
            boolean signal = i % 2 == 1;
            int max = 0;
            for (int j = signal ? half + 1 : half; j <= i - 1; j++) {
                max = Math.max(dp[j] * (i - j), max);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
// @lc code=end

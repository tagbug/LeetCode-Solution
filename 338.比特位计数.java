/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[] { 0 };
        }
        int[] dp = new int[n + 1];

        // 边界
        dp[0] = 0;
        dp[1] = 1;

        for (int dex = 1; Math.pow(2, dex) <= n; dex++) {
            int pow = (int) Math.pow(2, dex);
            int next = pow * 2;
            for (int i = pow; i < next; i++) {
                if (i > n) {
                    break;
                }
                dp[i] = dp[i - pow] + 1;
            }
        }

        return dp;
    }
}
// @lc code=end

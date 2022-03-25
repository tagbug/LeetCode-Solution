/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    private static int[] queueNum = new int[100];

    static {
        // 打表 O(100)
        for (int i = 1; i <= 100; i++) {
            queueNum[i - 1] = i * i;
        }
    }

    public int numSquares(int n) {
        // O(100*N)
        // dp[i] = MIN(dp[i - queue[j]] + 1), j∈[0,99]
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            int min = dp[i - queueNum[0]] + 1;
            for (int j = 1; j < queueNum.length; j++) {
                int num = queueNum[j];
                if (i - num < 0) {
                    break;
                }
                min = Math.min(min, dp[i - num] + 1);
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
// @lc code=end

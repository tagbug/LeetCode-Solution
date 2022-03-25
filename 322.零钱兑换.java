import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // dp[i]: i的金额最少需要多少枚硬币凑成
        int[] dp = new int[amount + 1];
        // 初始状态
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        // dp
        for (int i = 1; i <= amount; i++) {
            int min = 0x3f3f3f3f;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            if (min == 0x3f3f3f3f) {
                dp[i] = -1;
            } else {
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}
// @lc code=end

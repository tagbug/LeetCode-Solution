/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        // dp[i]：表示前i间房屋的最大收益
        int[] dp = new int[len + 1];

        // 初态
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= len; i++) {
            // 前i间的最大收益=要么是前i-1间的收益，要么是前i-2间的收益+第i间收益
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }
}
// @lc code=end

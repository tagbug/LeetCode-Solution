/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        if (nums.length > 0) {
            dp[0][0] = nums[0];
        }
        if (nums.length > 1) {
            dp[0][1] = Math.max(dp[0][0], nums[1]);
            dp[1][0] = nums[1];
        }
        if (nums.length > 2) {
            dp[1][1] = Math.max(dp[1][0], nums[2]);
        }
        for (int i = 2; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + nums[i]);
        }
        if (nums.length == 1) {
            return dp[0][0];
        }
        for (int i = 2; i < nums.length - 1; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + nums[i + 1]);
        }
        return Math.max(dp[0][nums.length - 2], dp[1][nums.length - 2]);
    }
}
// @lc code=end

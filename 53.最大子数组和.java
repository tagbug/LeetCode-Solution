/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] < 0) {
                max = Math.max(max, dp[i - 1]);
            }
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        max = Math.max(max, dp[dp.length - 1]);
        return max;
    }
}
// @lc code=end

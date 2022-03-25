/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        dp[0][0] = nums[0];
        dp[nums.length - 1][nums.length - 1] = nums[nums.length - 1];
        if (nums.length > 1) {
            dp[0][1] = Math.max(nums[0], nums[1]);
            dp[1][1] = nums[1];
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[j];
                }
                if (i < j) {
                    int max = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    if (nums[j] > 0) {
                        max += nums[j];
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
// @lc code=end

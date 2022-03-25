/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {

    public int splitArray(int[] nums, int m) {
        // 前缀和
        int[] preSum = new int[nums.length + 1];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int[][] dp = new int[nums.length][m + 1];

        // 边界情况
        for (int i = 0; i < nums.length; i++) {
            dp[i][1] = preSum[i];
        }

        for (int k = 2; k <= m; k++) {
            for (int i = k - 1; i < nums.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = k - 2; j < i; j++) {
                    min = Math.min(min, Math.max(dp[j][k - 1], preSum[i] - preSum[j]));
                }
                dp[i][k] = min;
            }
        }

        return dp[nums.length - 1][m];
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        // dp[i][j]: nums[i]~nums[j]是否能构成等差数列     --O(N^2) --非最优
        boolean[][] dp = new boolean[nums.length][nums.length];
        // 初始化
        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                dp[i][i + 2] = true;
                count++;
            }
        }
        // dp
        for (int len = 4; len <= nums.length; len++) {
            for (int i = len - 1; i < nums.length; i++) {
                if (dp[i - len + 1][i - 1] && nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp[i - len + 1][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

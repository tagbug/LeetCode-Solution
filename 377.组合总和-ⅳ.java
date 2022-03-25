/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]：i为target的时候，。。。。。
        int[] dp = new int[target + 1];

        // 初始化
        for (int num : nums) {
            if (num <= target) {
                dp[num] = 1;
            }
        }

        for (int i = 1; i <= target; i++) {
            int num = 0, count = 0;
            for (int j = 0; j < nums.length; j++) {
                num = nums[j];
                if (num > i) {
                    continue;
                }
                if (num == i) {
                    count += 1;
                    continue;
                }
                count += dp[i - num];
            }
            dp[i] = count;
        }

        return dp[target];
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] score = new int[10001];
        int max = 0, min = 10001;
        for (int num : nums) {
            score[num] += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] dp = new int[10001];
        dp[1] = score[1];
        for (int i = Math.max(2, min); i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], score[i] + dp[i - 2]);
        }
        return dp[max];
    }
}
// @lc code=end

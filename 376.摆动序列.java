/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        // dp[i][status]：以第i个元素结尾的最长子序列（status是不同状态：下一个要升序/降序）
        int[][] dp = new int[len][2];

        dp[0][0] = dp[0][1] = 1;

        for (int i = 1; i < dp.length; i++) {
            int upMax = 1;
            int downMax = 1;
            // 此处保证连续递增性（不符合题意）
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    // down
                    downMax = Math.max(downMax, dp[j][1] + 1);
                } else if (nums[i] > nums[j]) {
                    // up
                    upMax = Math.max(upMax, dp[j][0] + 1);
                }
            }
            dp[i][0] = downMax;
            dp[i][1] = upMax;
        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
// @lc code=end

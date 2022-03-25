/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int i = 0, j = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (sum >= target) {
                // 收缩i
                while (sum >= target) {
                    sum -= nums[i++];
                }
                minSize = Math.min(minSize, j - i + 1);
            } else {
                // 扩展j
                sum += nums[j++];
            }
        }
        if (sum >= target) {
            // 收缩i
            while (sum >= target) {
                sum -= nums[i++];
            }
            minSize = Math.min(minSize, j - i + 1);
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int i = 1;
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return true;
        }
        i = 1;
        while (i < nums.length && nums[i] <= nums[i - 1]) {
            i++;
        }
        return i == nums.length;
    }
}
// @lc code=end

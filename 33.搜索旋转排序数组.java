/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (target >= nums[0]) {
            // 从前往后找
            if (target == nums[0]) {
                return 0;
            }
            for (int i = 1; i < nums.length && nums[i] > nums[i - 1]; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        } else {
            // 从后往前找
            if (target == nums[nums.length - 1]) {
                return nums.length - 1;
            }
            for (int i = nums.length - 2; i >= 0 && nums[i] < nums[i + 1]; i--) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
// @lc code=end

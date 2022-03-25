/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    private int res;
    private int[] nums;
    private int len;

    private void binarySearch(int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (mid + 1 >= len) {
            return;
        }
        if (nums[mid] > nums[mid + 1]) {
            res = nums[mid + 1];
            return;
        }
        binarySearch(left, mid - 1);
        binarySearch(mid + 1, right);
    }

    public int findMin(int[] nums) {
        this.res = nums[0];
        this.nums = nums;
        len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (nums[0] < nums[len - 1]) {
            // 未旋转或旋转了n次
            return nums[0];
        }
        // 一般情况
        int left = 0, right = len - 1;
        binarySearch(left, right);
        return res;
    }
}
// @lc code=end


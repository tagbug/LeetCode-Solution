/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    private int[] nums;
    private int len;
    private int res;

    private void binarySearch(int low, int hi) {
        if (low > hi) {
            return;
        }
        int mid = (low + hi) / 2;
        boolean find = true;
        if (mid - 1 >= 0) {
            find &= nums[mid] > nums[mid - 1];
        }
        if (mid + 1 <= len - 1) {
            find &= nums[mid] > nums[mid + 1];
        }
        if (find) {
            res = mid;
            return;
        }
        binarySearch(low, mid - 1);
        binarySearch(mid + 1, hi);
    }

    public int findPeakElement(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        binarySearch(0, len - 1);
        return res;
    }
}
// @lc code=end

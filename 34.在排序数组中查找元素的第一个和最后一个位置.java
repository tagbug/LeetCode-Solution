/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    private int[] nums;
    private int target;

    public int binarySearch(int low, int hi) {
        if (low > hi) {
            return -1;
        }
        int mid = (low + hi) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        int left = binarySearch(low, mid - 1);
        int right = binarySearch(mid + 1, hi);
        if (left >= 0) {
            return left;
        }
        if (right >= 0) {
            return right;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int idx = binarySearch(0, nums.length - 1);
        if (idx == -1) {
            return new int[] { -1, -1 };
        }
        int left, right;
        for (left = idx - 1; left >= 0; left--) {
            if (nums[left] != target) {
                break;
            }
        }
        for (right = idx + 1; right <= nums.length - 1; right++) {
            if (nums[right] != target) {
                break;
            }
        }
        return new int[] { left + 1, right - 1 };
    }
}
// @lc code=end

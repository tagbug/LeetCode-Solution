import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    public int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] > right[r]) {
                arr[l + r] = left[l];
                l++;
            } else {
                arr[l + r] = right[r];
                r++;
            }
        }
        while (l < left.length) {
            arr[l + r] = left[l];
            l++;
        }
        while (r < right.length) {
            arr[l + r] = right[r];
            r++;
        }
        return arr;
    }

    public int[] sort(int[] arr, int start, int end) {
        if (start == end) {
            return new int[] { arr[start] };
        }
        // 0 1 2 3 4 5
        int mid = (start + end) / 2;
        // divided to [start, mid] [mid + 1, end]
        int[] left = sort(arr, start, mid);
        int[] right = sort(arr, mid + 1, end);
        return merge(left, right);
    }

    public int findKthLargest(int[] nums, int k) {
        int[] sorted = sort(nums, 0, nums.length - 1);
        return sorted[k - 1];
        /*
         * Arrays.sort(nums);
         * return nums[nums.length - k - 1];
         */
    }
}
// @lc code=end

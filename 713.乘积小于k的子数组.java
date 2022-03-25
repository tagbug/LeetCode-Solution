/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        // 滑动窗口
        int i = 0, j = 1;
        int multi = nums[0];
        while (j < nums.length) {
            if (i > j) {
                j++;
                continue;
            }
            if (multi < k) {
                // 找到解
                res += j - i;
                // System.out.println((j - i) + " " + i + " " + (j - 1));
                multi *= nums[j++];
            } else {
                // System.out.println(multi + " " + k);
                multi /= nums[i++];
            }
        }
        while (i < j) {
            if (multi < k) {
                // 找到解
                res += j - i;
                // System.out.println((j - i) + " " + i + " " + (j - 1));
                break;
            } else {
                // System.out.println(multi + " " + k);
                multi /= nums[i++];
            }
        }
        return res;
    }
}
// @lc code=end

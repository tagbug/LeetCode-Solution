import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int idx = Arrays.binarySearch(nums, 1);
        if (idx < 0) {
            return 1;
        } else {
            for (int i = idx, j = 1; i < nums.length; i++) {
                if (nums[i] != j) {
                    if (nums[i] == j + 1) {
                        j++;
                    } else {
                        return j + 1;
                    }
                }
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
// @lc code=end

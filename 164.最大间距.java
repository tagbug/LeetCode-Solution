import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxMinus = 0, preNum = nums[0];
        for (int num : nums) {
            maxMinus = Math.max(maxMinus, num - preNum);
            preNum = num;
        }
        return maxMinus;
    }
}
// @lc code=end


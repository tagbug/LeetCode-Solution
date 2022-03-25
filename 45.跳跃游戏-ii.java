/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // greed
        int max = nums[0], bound = nums[0], jump = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i > bound) {
                jump++;
                bound = max;
            }
            max = Math.max(max, i + nums[i]);
        }
        return jump;
    }
}
// @lc code=end

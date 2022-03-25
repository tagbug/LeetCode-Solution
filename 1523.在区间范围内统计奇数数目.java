/*
 * @lc app=leetcode.cn id=1523 lang=java
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 1) {
            return (high - low) / 2 + 1;
        } else {
            if (low == high)
                return 0;
            return (high - low - 1) / 2 + 1;
        }
    }
}
// @lc code=end


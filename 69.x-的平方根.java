/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1, hi = x;
        while (low < hi) {
            int mid = (int) (((long) low + (long) hi) >> 1);
            if (mid * mid >= x) {
                // 往小找
                hi = mid;
            } else {
                // 往大找
                low = mid + 1;
            }
        }
        return low * low == x ? low : low - 1;
    }
}
// @lc code=end

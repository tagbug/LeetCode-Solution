/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
/* class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1)
            return x;
        if (x == -1) {
            if (n % 2 == 0)
                return 1.0;
            else
                return -1.0;
        }
        if (n == 0)
            return 1.0;
        if (n > 0) {
            double result = x;
            for (int i = 1; i < n; i++)
                result *= x;
            return result;
        } else {
            if (n == -2147483648) {
                n = 2147483647;
            } else {
                n = -n;
            }
            if (n > 1E8)
                return 0.0;
            double result = x;
            for (int i = 1; i < n; i++)
                result *= x;
            return 1.0 / result;
        }
    }
} */
// @lc code=end

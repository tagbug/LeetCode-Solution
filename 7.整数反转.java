/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public long convert(long x) {
        int len = (int) Math.log10(x) + 1;
        long[] arr = new long[len];
        long radix = 1;
        for (int i = 0; i < len; i++, radix *= 10) {
            arr[i] = x / radix % 10;
        }
        long res = 0;
        radix = 1;
        for (int i = len - 1; i >= 0; i--, radix *= 10) {
            res += arr[i] * radix;
        }
        return res;
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long num = x;
        boolean isNegative = num < 0;
        num = isNegative ? -num : num;
        long res = convert(num);
        res = isNegative ? -res : res;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
// @lc code=end

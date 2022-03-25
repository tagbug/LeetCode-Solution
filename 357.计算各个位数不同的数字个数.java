/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {

    public static int countN(int n) {
        if (n == 1) {
            return 9;
        }
        int i = 9;
        for (int j = 9; n > 1; n--, j--) {
            i *= j;
        }
        return i;
    }

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + countN(i);
        }
        return dp[n];
    }
}
// @lc code=end

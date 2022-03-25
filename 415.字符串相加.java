/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int maxLen = Math.max(num1.length(), num2.length());
        char[] res = new char[maxLen + 1];
        int i = num1.length() - 1, j = num2.length() - 1, k = res.length - 1;
        for (; i >= 0 && j >= 0; i--, j--, k--) {
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + res[k];
            if (sum >= 10) {
                sum -= 10;
                res[k - 1] += 1;
            }
            res[k] = (char) ('0' + sum);
        }
        while (i >= 0) {
            int sum = num1.charAt(i--) - '0' + res[k];
            if (sum >= 10) {
                sum -= 10;
                res[k - 1] += 1;
            }
            res[k--] = (char) ('0' + sum);
        }
        while (j >= 0) {
            int sum = num2.charAt(j--) - '0' + res[k];
            if (sum >= 10) {
                sum -= 10;
                res[k - 1] += 1;
            }
            res[k--] = (char) ('0' + sum);
        }
        if (res[0] == 0) {
            return new String(res, 1, res.length - 1);
        }
        res[0] += '0';
        return new String(res);
    }
}
// @lc code=end

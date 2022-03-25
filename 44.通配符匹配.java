/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    // 正确，但TLE
    /*
     * public static boolean match(String s, String p, int sPointer, int pPointer,
     * int letterLeft) {
     * if (pPointer == -1) {
     * return sPointer == -1;
     * }
     * // 优化：剪枝
     * if (letterLeft > sPointer + 1) {
     * return false;
     * }
     * char pChar = p.charAt(pPointer);
     * if (sPointer == -1) {
     * if (pChar == '*') {
     * return match(s, p, sPointer, pPointer - 1, letterLeft);
     * } else {
     * return false;
     * }
     * }
     * if (pChar == '*') {
     * // 优化：合并*号
     * int k = pPointer;
     * while (k > 0 && p.charAt(k - 1) == '*') {
     * k--;
     * }
     * pPointer = k;
     * for (int i = -1; i <= sPointer; i++) {
     * if (match(s, p, i, pPointer - 1, letterLeft)) {
     * return true;
     * }
     * }
     * return false;
     * } else if (pChar == '?') {
     * return match(s, p, sPointer - 1, pPointer - 1, letterLeft - 1);
     * } else {
     * // a-z
     * if (pChar == s.charAt(sPointer)) {
     * return match(s, p, sPointer - 1, pPointer - 1, letterLeft - 1);
     * } else {
     * return false;
     * }
     * }
     * }
     * 
     * public boolean isMatch(String s, String p) {
     * if (p.length() == 0) {
     * return s.length() == 0 ? true : false;
     * }
     * int sPointer = s.length() - 1;
     * int pPointer = p.length() - 1;
     * int letterLeft = 0;
     * for (int i = 0; i < p.length(); i++) {
     * if (p.charAt(i) != '*') {
     * letterLeft += 1;
     * }
     * }
     * 
     * return match(s, p, sPointer, pPointer, letterLeft);
     * }
     */

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0 ? true : false;
        }
        // 前p个字符能否匹配前s个字符
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int pPointer = 1; pPointer <= p.length(); pPointer++) {
            char pChar = p.charAt(pPointer - 1);
            // *号单独处理
            if (pChar == '*') {
                for (int sPointer = 0; sPointer <= s.length(); sPointer++) {
                    if (dp[pPointer - 1][sPointer]) {
                        dp[pPointer][sPointer] = true;
                        break;
                    }
                }
                continue;
            }
            // 一般情况
            for (int sPointer = 1; sPointer <= s.length(); sPointer++) {
                // 如果前面匹配成功过
                if (dp[pPointer - 1][sPointer - 1]) {
                    dp[pPointer][sPointer] = (pChar == '?') ? true : (pChar == s.charAt(sPointer - 1));
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int maxLen = s1.length();
        boolean[][][] dp = new boolean[maxLen][maxLen][maxLen + 1];

        // 初始化单个字符的情况
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < maxLen; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        // 按长度遍历
        for (int len = 2; len <= maxLen; len++) {
            for (int i = 0; i < maxLen - len + 1; i++) {
                for (int j = 0; j < maxLen - len + 1; j++) {
                    boolean flag = false;
                    for (int k = 1; k < len; k++) {
                        flag = (dp[i][j][k] && dp[i + k][j + k][len - k])
                                || (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                        if (flag) {
                            break;
                        }
                    }
                    dp[i][j][len] = flag;
                    // System.out.println(String.format("%d %d Len: %d " + flag, i, j, len));
                }
            }
        }

        return dp[0][0][maxLen];
    }
}
// @lc code=end

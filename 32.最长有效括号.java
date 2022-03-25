/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 0;
        int maxLength = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                int j = i - 1;
                while (j >= 0) {
                    if (dp[j] == 0) {
                        // 尝试匹配
                        if (s.charAt(j) == '(') {
                            dp[i] = i - j + 1;
                            int k = j - 1;
                            while (k >= 0) {
                                if (dp[k] == 0) {
                                    break;
                                }
                                dp[i] += dp[k];
                                k -= dp[k];
                            }
                            maxLength = maxLength > dp[i] ? maxLength : dp[i];
                        }
                        break;
                    } else {
                        j -= dp[j];
                    }
                }
            }
        }
        return maxLength;
    }
}
// @lc code=end

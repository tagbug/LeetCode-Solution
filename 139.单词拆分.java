import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    private String s;

    public boolean stringEqual(int low, int high, String cmp) {
        for (int i = 0; i + low <= high; i++) {
            if (s.charAt(i + low) != cmp.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        // 初态
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (String sub : wordDict) {
                int subLen = sub.length();
                dp[i] = (i - subLen >= 0) && dp[i - subLen] && stringEqual(i - subLen, i - 1, sub);
                if (dp[i])
                    break;
            }
        }

        return dp[len];
    }
}
// @lc code=end

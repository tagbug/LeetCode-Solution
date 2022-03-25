/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {

    public boolean judge(char a) {
        return '1' <= a && a <= '9';
    }

    public boolean judge(char a, char b) {
        if (a == '1') {
            return '0' <= b && b <= '9';
        }
        if (a == '2') {
            return '0' <= b && b <= '6';
        }
        return false;
    }

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];

        // 边界单独处理
        dp[0] = 1;
        dp[1] = judge(s.charAt(0)) ? 1 : 0;

        // 从第二个字符开始dp
        for (int i = 2; i <= len; i++) {
            boolean flag1 = judge(s.charAt(i - 1));
            boolean flag2 = judge(s.charAt(i - 2), s.charAt(i - 1));
            dp[i] = (flag1 ? dp[i - 1] : 0) + (flag2 ? dp[i - 2] : 0);
        }

        return dp[len];
    }
}
// @lc code=end

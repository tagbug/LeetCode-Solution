/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    class Max {
        int i, j;
        int value;
    }

    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        Max max = new Max();

        for (int k = 0; k < N; k++) {
            int i = k;
            int j = i + 1;
            while (i >= 0 && j < N) {
                if (i + 1 >= j - 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (max.value < len) {
                        max.i = i;
                        max.j = j;
                        max.value = len;
                    }
                }
                i--;
                j++;
            }
        }
        for (int k = 0; k < N; k++) {
            int i = k;
            int j = i + 2;
            while (i >= 0 && j < N) {
                if (i + 1 >= j - 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (max.value < len) {
                        max.i = i;
                        max.j = j;
                        max.value = len;
                    }
                }
                i--;
                j++;
            }
        }

        return s.substring(max.i, max.j + 1);
    }
}
// @lc code=end

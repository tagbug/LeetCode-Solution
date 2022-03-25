/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        for (int i = 1; i < len; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        // dp[x][k]：第stones[x]格是否能跳到(k为上一次k值)，kMax = stones.length
        boolean[][] dp = new boolean[len][len];

        // 初始化
        dp[0][0] = true;

        // 每一轮循环到的stones[x]值的最大k值为i
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == len - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

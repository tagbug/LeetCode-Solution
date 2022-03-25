import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[2][len];

        // 初始情况
        dp[0][0] = triangle.get(0).get(0);

        // dp
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle.get(i).get(j);
                    continue;
                }
                if (j == i) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + triangle.get(i).get(j);
                    continue;
                }
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1] + triangle.get(i).get(j), dp[(i - 1) % 2][j]
                        + triangle.get(i).get(j));
            }
        }

        // 找出最小
        int min = dp[(len - 1) % 2][0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, dp[(len - 1) % 2][i]);
        }
        return min;
    }
}
// @lc code=end

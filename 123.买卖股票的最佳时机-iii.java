/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    // O(N^2) => TLE
    /*
     * public int maxProfit(int[] prices) {
     * int len = prices.length;
     * 
     * // 区间Max（左半区间&右半区间）
     * int[][] max = new int[len][2];
     * 
     * // 初始态（[0,len-1]）
     * max[len - 1][1] = prices[len - 1];
     * for (int i = len - 2; i >= 0; i--) {
     * max[i][1] = Math.max(prices[i], max[i + 1][1]);
     * }
     * 
     * // 区间最大利润（左半区间&右半区间）
     * int[][] profit = new int[len + 1][2];
     * 
     * // 初始态（[0,len-1]）
     * // 从len-2开始，因为profit[len-1]=0
     * for (int i = len - 2; i >= 0; i--) {
     * int minus = max[i + 1][1] - prices[i];
     * profit[i][1] = Math.max(profit[i + 1][1], minus);
     * }
     * 
     * // 区间分割
     * int maxProfit = 0;
     * for (int divide = 1; divide <= len; divide++) {
     * // 计算左半区间Max
     * max[divide - 1][0] = prices[divide - 1];
     * for (int i = divide - 2; i >= 0; i--) {
     * max[i][0] = Math.max(prices[divide - 1], max[i][0]);
     * }
     * // 计算左半区间Profit
     * for (int i = divide - 2; i >= 0; i--) {
     * int minus = max[i + 1][0] - prices[i];
     * profit[i][0] = Math.max(profit[i + 1][0], minus);
     * }
     * // 更新最大Profit
     * maxProfit = Math.max(maxProfit, profit[0][0] + profit[divide][1]);
     * }
     * 
     * return maxProfit;
     * }
     */

    // O(N)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][status]：第i天的最大收益，status是当天选择的状态
        int[][] dp = new int[len][5];

        // 初态
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        int max = 0;
        for (int i = 1; i < 5; i++) {
            max = Math.max(max, dp[len - 1][i]);
        }
        
        return max;
    }
}
// @lc code=end

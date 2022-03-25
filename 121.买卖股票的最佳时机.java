/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length];

        // 区间max
        max[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], prices[i]);
        }

        int maxProfit = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            int minus = max[i + 1] - prices[i];
            maxProfit = Math.max(maxProfit, minus);
        }

        return maxProfit;
    }
}
// @lc code=end

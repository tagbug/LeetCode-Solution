/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    // TLE
    /* public int maxProduct(int[] nums) {
        int numsLen = nums.length;
        int[][] dp = new int[2][numsLen];
    
        int max = Integer.MIN_VALUE;
        // 初态
        for (int i = 0; i < numsLen; i++) {
            dp[1][i] = nums[i];
            max = Math.max(max, dp[1][i]);
        }
    
        for (int len = 2; len < numsLen; len++) {
            for (int i = 0; i <= numsLen - len; i++) {
                dp[len % 2][i] = dp[(len - 1) % 2][i] * nums[i + len - 1];
                max = Math.max(max, dp[len % 2][i]);
            }
        }
    
        return max;
    } */
    
    // O(N)  难点：负负得正
    public int maxProduct(int[] nums) {
        int len = nums.length;
        // max[i]：以第i个元素结尾的最大连续积
        int[] max = new int[len];
        // min[i]：以第i个元素结尾的最小连续积
        int[] min = new int[len];

        // 初态
        max[0] = min[0] = nums[0];

        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
        }

        int res = max[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
// @lc code=end

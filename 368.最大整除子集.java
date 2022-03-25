import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // sort
        Arrays.sort(nums);

        // dp[i]：以第i个元素为最大元素的最大整除子集大小
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>(max);

        int idx = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == max) {
                idx = i;
                ans.add(nums[i]);
                max--;
                break;
            }
        }

        int elem = nums[idx];
        for (int i = idx - 1; i >= 0; i--) {
            if (dp[i] == max && elem % nums[i] == 0) {
                max--;
                elem = nums[i];
                ans.add(nums[i]);
                if (max == 0) {
                    break;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // two-pointer
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                int k = i + 1;
                for (; k < j; k++) {
                    if (height[k] > height[i]) {
                        break;
                    }
                }
                i = k;
            } else {
                int k = j - 1;
                for (; k > i; k--) {
                    if (height[k] > height[j]) {
                        break;
                    }
                }
                j = k;
            }
        }
        return max;
    }
}
// @lc code=end

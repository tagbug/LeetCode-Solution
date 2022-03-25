/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int len = nums.length;
        // 从后往前找一个降序排列
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        // System.out.println(i);
        if (i != -1) {
            // 再倒序找[i+1,len-1]中比nums[i]大的那个
            int j = len - 1;
            for (; j >= i + 1; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            // System.out.println(j);
            // 交换
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        // 对[i+1,len-1]升序排列
        for (int low = i + 1, hi = len - 1; low < hi; low++, hi--) {
            int tmp = nums[low];
            nums[low] = nums[hi];
            nums[hi] = tmp;
        }
    }
}
// @lc code=end

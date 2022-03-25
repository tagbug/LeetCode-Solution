import java.util.concurrent.PriorityBlockingQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int low = 0, hi = k - 1;
        PriorityBlockingQueue<int[]> queue = new PriorityBlockingQueue<>(nums.length, (a, b) -> b[1] - a[1]);
        // init
        for (int i = low; i <= hi; i++) {
            queue.add(new int[] { i, nums[i] });
        }
        res[0] = queue.peek()[1];
        // traverse
        for (; ++hi < nums.length; low++) {
            queue.add(new int[] { hi, nums[hi] });
            int[] max = queue.peek();
            while (max[0] <= low) {
                queue.poll();
                max = queue.peek();
            }
            res[low + 1] = max[1];
        }
        return res;
    }
}
// @lc code=end

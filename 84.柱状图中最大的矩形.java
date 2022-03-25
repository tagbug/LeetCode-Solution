import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            if (!stack.isEmpty()) {
                int last = stack.peek();
                // 最后一个在栈中的高度
                while (heights[last] > heights[i]) {
                    int hi = heights[stack.pop()];
                    if (!stack.isEmpty()) {
                        last = stack.peek();
                        int w = i - last - 1;
                        max = Math.max(max, hi * w);
                        // System.out.println(hi + " " + w + " " + hi * w);
                    } else {
                        max = Math.max(max, hi * i);
                        // System.out.println(hi + " " + hi * i);
                        break;
                    }
                }
            }

            stack.push(i);
        }

        if (!stack.isEmpty()) {
            int last = stack.peek();
            int len = heights.length;
            // 最后一个在栈中的高度
            while (true) {
                int hi = heights[stack.pop()];
                if (!stack.isEmpty()) {
                    last = stack.peek();
                    int w = len - last - 1;
                    max = Math.max(max, hi * w);
                } else {
                    max = Math.max(max, hi * len);
                    break;
                }
            }
        }

        return max;
    }
}
// @lc code=end

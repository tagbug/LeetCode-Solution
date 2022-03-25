import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    Stack<Integer> stack;
    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * @param start 从数字几开始
     * @param k     题目k值
     * @param n     题目n值
     */
    public void search(int start, int k, int n) {
        if (k <= 0) {
            // 结束
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            stack.push(i);
            search(i + 1, k - 1, n);
            stack.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        stack = new Stack<>();
        search(1, k, n);
        return ans;
    }
}
// @lc code=end

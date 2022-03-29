import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private int[] nums;
    private boolean[] used;
    private ArrayList<List<Integer>> ans;
    private Stack<Integer> stack = new Stack<>();

    private void search() {
        boolean next = false;
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                next = true;
                used[i] = true;
                stack.push(nums[i]);
                search();
                used[i] = false;
                stack.pop();
            }
        }
        if (!next) {
            // find ans
            ans.add(List.copyOf(stack));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        ans = new ArrayList<>((int) Math.pow(2, nums.length));
        search();
        return ans;
    }
}
// @lc code=end


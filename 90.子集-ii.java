import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    private int len;
    private int[] nums;
    private HashSet<List<Integer>> res;

    private void addRes(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((n >> i) % 2 == 1) {
                list.add(nums[i]);
            }
        }
        list.sort((a, b) -> a - b);
        res.add(list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // bit-manipulation
        this.res = new HashSet<>((int) Math.pow(2, len));
        this.len = nums.length;
        this.nums = nums;
        for (int i = (int) Math.pow(2, len) - 1; i >= 0; i--) {
            addRes(i);
        }
        return List.copyOf(res);
    }
}
// @lc code=end

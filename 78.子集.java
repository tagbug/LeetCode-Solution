import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    private int len;
    private int[] nums;
    private ArrayList<List<Integer>> res = new ArrayList<>();

    private void addRes(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((n >> i) % 2 == 1) {
                list.add(nums[i]);
            }
        }
        res.add(list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // bit-manipulation
        this.len = nums.length;
        this.nums = nums;
        for (int i = (int) Math.pow(2, len) - 1; i >= 0; i--) {
            addRes(i);
        }
        return res;
    }
}
// @lc code=end

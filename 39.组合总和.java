import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    int target;
    int sum;
    int[] candidates;
    int[] count;
    ArrayList<List<Integer>> ans;

    public void search(int start) {
        while (sum < target) {
            if (start + 1 < candidates.length)
                search(start + 1);
            count[start]++;
            sum += candidates[start];
        }
        if (target == sum) {
            // find answer
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < candidates.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    list.add(candidates[i]);
                }
            }
            ans.add(list);
        }
        // clear state
        sum -= candidates[start] * count[start];
        count[start] = 0;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        count = new int[candidates.length];
        ans = new ArrayList<List<Integer>>();
        search(0);
        return ans;
    }
}
// @lc code=end

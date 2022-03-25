import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        int low = intervals[0][0], hi = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > hi) {
                ans.add(new int[] { low, hi });
                low = intervals[i][0];
                hi = intervals[i][1];
            } else {
                hi = Math.max(hi, intervals[i][1]);
            }
        }
        ans.add(new int[] { low, hi });
        int[][] res = new int[ans.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
// @lc code=end

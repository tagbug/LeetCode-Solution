import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][] {};
        }
        ArrayList<int[]> res = new ArrayList<>();
        // two-pointer
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                res.add(new int[] { left, right });
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[res.size()][];
        for (int k = 0; k < ans.length; k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    static int[] x;
    static int ans;

    /**
     * @param row form 0 to x.length-1
     */
    public static boolean canPlace(int row) {
        for (int i = 1; i <= row; i++) {
            if (x[row] == x[row - i] || Math.abs(x[row] - x[row - i]) == i) {
                return false;
            }
        }
        return true;
    }

    static void solve(int i, int j) {
        if (i >= x.length) {
            // 已找到解法
            ans++;
            return;
        }
        while (i < x.length) {
            while (j < x.length) {
                x[i] = j;
                if (canPlace(i)) {
                    solve(i + 1, 0);
                }
                j++;
            }
            i++;
        }
    }

    public int totalNQueens(int n) {
        x = new int[n];
        ans = 0;
        solve(0, 0);
        return ans;
    }
}
// @lc code=end

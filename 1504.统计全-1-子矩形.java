/*
 * @lc app=leetcode.cn id=1504 lang=java
 *
 * [1504] 统计全 1 子矩形
 */

// @lc code=start
class Solution {
    public int numSubmat(int[][] mat) {
        // O(n^3)
        int[][] row = new int[mat.length][mat[0].length];
        // 初始化row
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row[0].length; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] == 0) {
                    row[i][j] = 0;
                } else {
                    row[i][j] = row[i][j - 1] + 1;
                }
            }
        }
        // 枚举
        int res = 0;
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row[0].length; j++) {
                int len = row[i][j];
                for (int k = i; k >= 0 && len > 0; k--) {
                    len = Math.min(len, row[k][j]);
                    res += len;
                }
            }
        }
        return res;
    }
}
// @lc code=end

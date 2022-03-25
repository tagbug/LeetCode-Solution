/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        // 按列优先遍历
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if (i == 0 && j == 0) {
                    // 起始位置
                    continue;
                }
                if (i == 0) {
                    // 如果是第一行
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    // 第一列
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }
}
// @lc code=end

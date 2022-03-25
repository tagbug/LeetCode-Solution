/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        // 按列优先遍历
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if (obstacleGrid[i][j] == 1) {
                    // 格子上有障碍物
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        // 起始位置
                        obstacleGrid[i][j] = 1;
                        continue;
                    }
                    if (i == 0) {
                        // 如果是第一行
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                        continue;
                    }
                    if (j == 0) {
                        // 第一列
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                        continue;
                    }
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }
}
// @lc code=end

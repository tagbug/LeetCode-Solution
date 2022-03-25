/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    private char[][] grid;

    public boolean dfs(int i, int j) {
        if(grid[i][j]=='0')
            return false;
        grid[i][j] = '0';
        if (i > 0) {
            dfs(i - 1, j);
        }
        if (j > 0) {
            dfs(i, j - 1);
        }
        if (i < grid.length - 1) {
            dfs(i + 1, j);
        }
        if (j < grid[0].length - 1) {
            dfs(i, j + 1);
        }
        return true;
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
// @lc code=end

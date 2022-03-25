import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    private int[][] grid;
    private static int[][] dir = new int[][] { { -1, -1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { 0, 1 },
            { 1, 0 }, { 1, 1 } };

    private boolean ifContinue(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return false;
        }
        return true;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        this.grid = grid;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        grid[0][0] = 1;
        int count = 0, nextLeft = 1, left = 0;
        // BFS
        while (nextLeft != 0) {
            left = nextLeft;
            nextLeft = 0;
            count++;
            while (left-- != 0) {
                int[] now = queue.poll();
                int i = now[0], j = now[1];
                if (i == grid.length - 1 && j == grid.length - 1) {
                    // find result
                    return count;
                }
                for (int[] d : dir) {
                    if (ifContinue(i + d[0], j + d[1])) {
                        queue.add(new int[] { i + d[0], j + d[1] });
                        grid[i + d[0]][j + d[1]] = 1;
                        nextLeft++;
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    private int[][] image;
    private int initColor;
    private int newColor;

    public void dfs(int i, int j) {
        if (image[i][j] == newColor)
            return;
        image[i][j] = newColor;
        if (i > 0) {
            if (image[i - 1][j] == initColor)
                dfs(i - 1, j);
        }
        if (j > 0) {
            if (image[i][j - 1] == initColor)
                dfs(i, j - 1);
        }
        // 2-1=1
        if (i < image.length - 1) {
            if (image[i + 1][j] == initColor)
                dfs(i + 1, j);
        }
        // 3-1=2
        if (j < image[0].length - 1) {
            if (image[i][j + 1] == initColor)
                dfs(i, j + 1);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.newColor = newColor;
        this.initColor = image[sr][sc];
        dfs(sr, sc);
        return image;
    }
}
// @lc code=end

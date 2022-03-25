/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // sum[i][j]：前i行，前j列的元素总和
        int[][] sum = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = matrix[i][j];
                    continue;
                }
                if (i == 0) {
                    sum[i][j] = matrix[i][j] + sum[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j];
                    continue;
                }
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        this.sum = sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        }
        if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        }
        if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

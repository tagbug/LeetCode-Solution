import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    private int[][] matrix;
    private int target;

    private boolean columnSearch(int row) {
        if (matrix[row][0] > target) {
            return row - 1 >= 0 && Arrays.binarySearch(matrix[row - 1], target) >= 0;
        } else {
            return Arrays.binarySearch(matrix[row], target) >= 0;
        }
    }

    private boolean rowSearch(int low, int hi) {
        while (low < hi) {
            int mid = (low + hi) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                // 往低位
                hi = mid - 1;
            }
            if (matrix[mid][0] < target) {
                // 往高位
                low = mid + 1;
            }
        }
        return columnSearch(low);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        return rowSearch(0, matrix.length - 1);
    }
}
// @lc code=end

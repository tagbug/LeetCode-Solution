import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int leftPadding = 0,
                rightPadding = matrix[0].length - 1,
                topPadding = 0,
                bottomPadding = matrix.length - 1;
        ArrayList<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
        while (true) {
            // 左到右
            for (int j = leftPadding; j <= rightPadding; j++) {
                res.add(matrix[topPadding][j]);
            }
            topPadding++;
            if (topPadding > bottomPadding) {
                break;
            }
            // 上到下
            for (int i = topPadding; i <= bottomPadding; i++) {
                res.add(matrix[i][rightPadding]);
            }
            rightPadding--;
            if (leftPadding > rightPadding) {
                break;
            }
            // 右到左
            for (int j = rightPadding; j >= leftPadding; j--) {
                res.add(matrix[bottomPadding][j]);
            }
            bottomPadding--;
            if (topPadding > bottomPadding) {
                break;
            }
            // 下到上
            for (int i = bottomPadding; i >= topPadding; i--) {
                res.add(matrix[i][leftPadding]);
            }
            leftPadding++;
            if (leftPadding > rightPadding) {
                break;
            }
        }
        return res;
    }
}
// @lc code=end

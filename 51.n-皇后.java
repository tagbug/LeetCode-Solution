import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    static int[] x;
    static ArrayList<List<String>> ans;

    /**
     * 判断当前位置是否能放置皇后
     * 
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

    /**
     * 保存解法
     */
    public static void saveSolution() {
        ArrayList<String> oneSolve = new ArrayList<String>();
        for (int k = 0; k < x.length; k++) {
            char[] str = new char[x.length];
            Arrays.fill(str, '.');
            str[x[k]] = 'Q';
            oneSolve.add(new String(str));
        }
        ans.add(oneSolve);
    }

    /**
     * 搜索
     */
    static void search(int i, int j) {
        // 判断是否到达边界
        if (i >= x.length) {
            // 到达边界说明已找到解法
            saveSolution();
            return;
        }
        // 否则遍历每一个j，找合适的位置
        while (j < x.length) {
            x[i] = j;
            if (canPlace(i)) {
                search(i + 1, 0);
            }
            j++;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        x = new int[n];
        ans = new ArrayList<List<String>>(n);
        search(0, 0);
        return ans;
    }
}
// @lc code=end

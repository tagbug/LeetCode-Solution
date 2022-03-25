import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    private int[][] isConnected;
    private HashSet<Integer> set;
    private int count;

    private boolean dfs(int i) {
        if (!set.add(i)) {
            return false;
        }
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
                dfs(j);
            }
        }
        return true;
    }

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        set = new HashSet<>(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            count += dfs(i) ? 1 : 0;
        }
        return count;
    }
}
// @lc code=end

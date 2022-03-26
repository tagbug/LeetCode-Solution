/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    boolean[][] used;
    String word;
    char[][] board;
    int[][] next = new int[][] {
            { -1, 0 },
            { 0, -1 },
            { 1, 0 },
            { 0, 1 }
    };

    private boolean search(int i, int j, int k) {
        if (k >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j]
                || board[i][j] != word.charAt(k)) {
            return false;
        }
        used[i][j] = true;
        for (int[] entry : next) {
            if (search(i + entry[0], j + entry[1], k + 1)) {
                used[i][j] = false;
                return true;
            }
        }
        used[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.used = new boolean[board.length][board[0].length];
        this.word = word;
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

import java.util.HashSet;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    private HashSet<Entry> traversed;
    private char[][] board;
    private boolean exceedFlag;

    private class Entry {
        int i, j;
    
        /**
         * @param i
         * @param j
         */
        public Entry(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + Objects.hash(i, j);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Solution.Entry)) {
                return false;
            }
            Entry other = (Entry) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
                return false;
            }
            return i == other.i && j == other.j;
        }

        private Solution getEnclosingInstance() {
            return Solution.this;
        }

    }

    private void dfs(HashSet<Entry> set, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            exceedFlag = true;
            return;
        }
        if (board[i][j] == 'X' || traversed.contains(new Entry(i, j))) {
            return;
        }
        traversed.add(new Entry(i, j));
        set.add(new Entry(i, j));
        dfs(set, i - 1, j);
        dfs(set, i + 1, j);
        dfs(set, i, j + 1);
        dfs(set, i, j - 1);
    }

    public void solve(char[][] board) {
        this.board = board;
        traversed = new HashSet<>(board.length * board[0].length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !traversed.contains(new Entry(i, j))) {
                    exceedFlag = false;
                    HashSet<Entry> set = new HashSet<>();
                    dfs(set, i, j);
                    if (!exceedFlag) {
                        for (Entry entry : set) {
                            board[entry.i][entry.j] = 'X';
                        }
                    }
                }
            }
        }
    }
}
// @lc code=end

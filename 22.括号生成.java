import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    private int n;
    private char[] str;
    private int idx = 0;
    private ArrayList<String> res = new ArrayList<>();
    private int unclosed = 0;

    private void push(char c) {
        str[idx++] = c;
    }

    private void pop() {
        idx--;
    }

    private int size() {
        return idx;
    }

    private void open() {
        push('(');
        unclosed++;
    }

    private boolean close() {
        if (unclosed == 0) {
            return false;
        }
        push(')');
        unclosed--;
        return true;
    }

    public void pushOne(int left) {
        if (size() == n * 2) {
            if (unclosed == 0) {
                res.add(new String(str));
            }
            return;
        }
        if (left == 0) {
            // 只能闭合
            if (close()) {
                pushOne(left);
                pop();
                unclosed++;
            }
        } else {
            // 开放或者闭合
            open();
            pushOne(left - 1);
            pop();
            unclosed--;
            if (close()) {
                pushOne(left);
                pop();
                unclosed++;
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.str = new char[n * 2];
        pushOne(n);
        return res;
    }
}
// @lc code=end

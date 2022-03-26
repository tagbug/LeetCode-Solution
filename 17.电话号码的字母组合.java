import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String digits;
    ArrayList<String> ans;
    StringBuilder sb = new StringBuilder();
    char[][] map = new char[][] {
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    private void search(int idx) {
        if (idx >= digits.length()) {
            // find ans
            ans.add(sb.toString());
            return;
        }
        char[] chars = map[digits.charAt(idx) - '2'];
        for (char c : chars) {
            sb.append(c);
            search(idx + 1);
            sb.deleteCharAt(idx);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        ans = new ArrayList<>((int) Math.pow(3, digits.length()));
        this.digits = digits;
        search(0);
        return ans;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (sb1.length() != 0) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                sb1.append(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (sb2.length() != 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                sb2.append(c);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
// @lc code=end

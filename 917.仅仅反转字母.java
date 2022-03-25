/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public boolean alphabet(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public String reverseOnlyLetters(String s) {
        int max = s.length() - 1;
        int low = 0, high = max;

        StringBuffer sb = new StringBuffer();
        while (low <= max || high >= 0) {
            if (low <= max) {
                char lowChar = s.charAt(low);
                if (!alphabet(lowChar)) {
                    sb.append(lowChar);
                    low++;
                    continue;
                }
            }
            if (high >= 0) {
                char hiChar = s.charAt(high);
                if (alphabet(hiChar)) {
                    sb.append(hiChar);
                    low++;
                }
                high--;
            }
        }

        return sb.toString();
    }
}
// @lc code=end

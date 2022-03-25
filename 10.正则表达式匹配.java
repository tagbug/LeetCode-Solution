/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    int pLen;
    String s;
    int maxRepeatLen;
    char[] pattern;
    boolean[] canRepeat;

    public boolean search(int sIdx, int pIdx) {
        if (pIdx >= pLen && sIdx >= s.length()) {
            return true;
        }
        if (pIdx >= pLen) {
            return false;
        }
        if (sIdx >= s.length()) {
            boolean result = true;
            while (pIdx < pLen) {
                if (!canRepeat[pIdx]) {
                    result = false;
                    break;
                }
                pIdx++;
            }
            return result;
        }
        boolean result = false;
        if (canRepeat[pIdx]) {
            result = search(sIdx, pIdx + 1);
            if (result == true) {
                return true;
            }
            for (int i = 1; i <= maxRepeatLen && sIdx + i - 1 < s.length(); i++) {
                if (pattern[pIdx] == '.' || pattern[pIdx] == s.charAt(sIdx + i - 1)) {
                    result = search(sIdx + i, pIdx + 1);
                    if (result == true) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } else {
            if (pattern[pIdx] == '.' || pattern[pIdx] == s.charAt(sIdx)) {
                result = search(sIdx + 1, pIdx + 1);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        pattern = new char[p.length()];
        canRepeat = new boolean[p.length()];
        maxRepeatLen = s.length();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c != '*') {
                maxRepeatLen--;
                pattern[pLen++] = c;
            } else {
                maxRepeatLen++;
                canRepeat[pLen - 1] = true;
            }
        }
        return search(0, 0);
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    private String str;

    public int find(int start, int end, char c) {
        for (int i = start; i <= end; i++) {
            if (str.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        this.str = s;
        int left = 0, max = 0;
        for (int right = 1; right < len; right++) {
            int findIdx = find(left, right - 1, s.charAt(right));
            if (findIdx != -1) {
                left = findIdx + 1;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
// @lc code=end

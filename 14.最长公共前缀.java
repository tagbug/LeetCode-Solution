/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;
        char c;
        while (true) {
            if (idx >= strs[0].length()) {
                return strs[0].substring(0, idx);
            }
            c = strs[0].charAt(idx);
            for (String str : strs) {
                if (idx >= str.length() || str.charAt(idx) != c) {
                    return strs[0].substring(0, idx);
                }
            }
            idx++;
        }        
    }
}
// @lc code=end


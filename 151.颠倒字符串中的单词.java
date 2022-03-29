/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] words = trim.split("[ ]+");
        int low = 0, hi = words.length - 1;
        while (low < hi) {
            String tmp = words[low];
            words[low++] = words[hi];
            words[hi--] = tmp;
        }
        return String.join(" ", words);
    }
}
// @lc code=end


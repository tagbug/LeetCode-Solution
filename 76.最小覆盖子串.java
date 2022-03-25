/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // 生成映射集
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)] += 1;
        }
        int[] record = new int[128];
        // 滑动窗口
        String res = "";
        // 还剩几个字符
        int countLeft = t.length();
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        for (; right < s.length(); right++) {
            // 扩展right边界
            char c = s.charAt(right);
            if (map[c] > record[c]) {
                countLeft--;
            }
            record[c]++;
            if (countLeft == 0) {
                // 收缩left边界并得到答案
                while (left <= right) {
                    c = s.charAt(left);
                    if (map[c] == 0 || record[c] > map[c]) {
                        // 不需要这个字符 或者 可收缩
                        left++;
                        record[c]--;
                    } else {
                        break;
                    }
                }
                // 得到最小值
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                // left后移
                if (left <= right) {
                    c = s.charAt(left);
                    record[c]--;
                    left++;
                    countLeft++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }
        ArrayList<Integer> res = new ArrayList<>();
        // 滑动窗口
        int[] chars = new int[26];
        int[] count = new int[26];
        // 初始化
        for (int k = 0; k < p.length(); k++) {
            chars[p.charAt(k) - 'a']++;
        }
        // 全覆盖
        int i = 0, j = 0;
        for (; j < p.length(); j++) {
            count[s.charAt(j) - 'a']++;
        }
        if (Arrays.equals(chars, count)) {
            res.add(0);
        }
        // 滑动窗口
        for (; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            count[s.charAt(i++) - 'a']--;
            if (Arrays.equals(chars, count)) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

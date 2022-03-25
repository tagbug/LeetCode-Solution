/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);

        int j = 0;
        for (int i = 0; i < k; i++) {
            for (; j + 1 < sb.length() && sb.charAt(j + 1) >= sb.charAt(j); j++) {
            }
            if (j + 1 >= sb.length()) {
                break;
            }
            sb.delete(j, j + 1);
        }

        String res=  sb.substring(0, len - k).replaceFirst("^0+", "");
        return res.isEmpty() ? "0" : res;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    private String s;
    private int len;

    private int decode(int start, StringBuilder sb) {
        if (s.charAt(start) >= '0' && s.charAt(start) <= '9') {
            // 数字开头
            int numEnd = start;
            while (s.charAt(numEnd + 1) >= '0' && s.charAt(numEnd + 1) <= '9') {
                numEnd++;
            }
            int repeatNum = Integer.parseInt(s.substring(start, numEnd + 1));
            int i = numEnd + 2;
            for (; s.charAt(i) != ']'; i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    StringBuilder sb1 = new StringBuilder();
                    i = decode(i, sb1);
                    sb.append(sb1);
                    continue;
                }
                sb.append(s.charAt(i));
            }
            sb.append(sb.toString().repeat(repeatNum - 1));
            return i;
        }
        return -1;
    }

    public String decodeString(String s) {
        this.s = s;
        this.len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder sb1 = new StringBuilder();
                i = decode(i, sb1);
                sb.append(sb1);
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

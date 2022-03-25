/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    private boolean isNegative = false;

    public int convert(String s, int left, int right) {
        long res = 0;
        long MAX = Integer.MAX_VALUE;
        // 最大10位
        int MIN_BIT = right - 9;
        if (left < MIN_BIT) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long radix = 1;
        while (right >= left && right >= MIN_BIT) {
            res += (s.charAt(right) - '0') * radix;
            radix *= 10;
            right--;
        }
        if (isNegative) {
            res = res > MAX + 1 ? MAX + 1 : -res;
        } else {
            res = res > MAX ? MAX : res;
        }
        return (int) res;
    }

    public int myAtoi(String s) {
        int left = 0, right = -1;
        int pointer = 0;
        boolean start = false, numStart = false;
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (start) {
                if (numStart) {
                    if (c >= '0' && c <= '9') {
                        right += 1;
                    } else {
                        // 到达末尾
                        break;
                    }
                } else {
                    if (c == '0') {
                        left += 1;
                        right += 1;
                    } else {
                        numStart = true;
                        pointer -= 1;
                    }
                }
                pointer += 1;
            } else {
                // 清除空格
                if (c == ' ') {
                    pointer += 1;
                } else {
                    // 首位
                    if (c == '-') {
                        isNegative = true;
                        pointer += 1;
                    } else if (c == '+') {
                        isNegative = false;
                        pointer += 1;
                    }
                    start = true;
                    right = left = pointer;
                    right -= 1;
                }
            }
        }
        if (right < left) {
            return 0;
        }
        return convert(s, left, right);
    }
}
// @lc code=end

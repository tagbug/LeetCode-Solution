import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // pop
                char matched = map.get(c);
                if (!stack.isEmpty() && stack.pop() == matched) {
                    continue;
                }
                return false;
            } else {
                // push
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end


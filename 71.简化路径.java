import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] subArr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String sub : subArr) {
            if ("..".equals(sub)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (sub.length() > 0 && !".".equals(sub)) {
                stack.push(sub);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuffer sb = new StringBuffer();
        for (String s : stack) {
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }
}
// @lc code=end

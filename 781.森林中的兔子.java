import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=781 lang=java
 *
 * [781] 森林中的兔子
 */

// @lc code=start
class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);

        int count = answers[0] + 1;
        int left = answers[0];
        int now = answers[0];
        for (int i = 1; i < answers.length; i++) {
            if (answers[i] != now || left == 0) {
                now = answers[i];
                left = answers[i];
                count += answers[i] + 1;
                continue;
            }
            left--;
        }

        return count;
    }
}
// @lc code=end

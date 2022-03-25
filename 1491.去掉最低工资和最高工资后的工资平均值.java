/*
 * @lc app=leetcode.cn id=1491 lang=java
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        int max, min, sum;
        sum = max = min = salary[0];
        for (int i = 1; i < salary.length; i++) {
            sum += salary[i];
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
        }

        sum = sum - max - min;
        return ((double) sum) / (salary.length - 2);
    }
}
// @lc code=end

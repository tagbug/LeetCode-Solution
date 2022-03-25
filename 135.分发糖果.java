/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        // 1 2 3 4 9 7 6 5 4 3 2 1
        // 1 2 3 4 8 7

        // [1,2,3,4,9,7,6,5,4,3,2,2,1,1,0]
        // 1 2 3 4 [5/7] 6 5 4 3 2 1 2 1 2 1

        // 1 0 2
        // 2 1 2

        // 1 2 2 2 2 1
        // 1 2 1 1 2 1
        int[] ans = new int[ratings.length];
        ans[0] = 1;
        for (int i = 0; i < ratings.length - 1;) {
            int left = i;
            if (ratings[i] < ratings[i + 1]) {
                while (i < ratings.length - 1 && ratings[i] < ratings[i + 1]) {
                    i++;
                }
                for (int j = left, k = 1; j <= i; j++) {
                    ans[j] = k++;
                }
            } else if (ratings[i] > ratings[i + 1]) {
                while (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                    i++;
                }
                int k = 1;
                for (int j = i; j > left; j--) {
                    ans[j] = k++;
                }
                // System.out.println(left + " " + ans[left] + " " + k);
                ans[left] = Math.max(ans[left], k);
            } else {
                while (i < ratings.length - 1 && ratings[i] == ratings[i + 1]) {
                    i++;
                }
                for (int j = left + 1; j <= i; j++) {
                    ans[j] = 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            // System.out.print(i + " ");
            sum += ans[i];
        }
        return sum;
    }
}
// @lc code=end

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>(nums.length);

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (a + nums[left] + nums[right] < 0) {
                    left++;
                } else if (a + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    res.add(List.of(a, nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }

        return List.copyOf(res);
    }
}
// @lc code=end

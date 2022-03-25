import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        // init set
        for (int num : nums) {
            set.add(num);
        }
        // find a num that has no pre-elem
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num++)) {
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
// @lc code=end


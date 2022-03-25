/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 数据结构解法：HashSet
        /* HashSet<Integer> set = new HashSet<>(nums.length);
        
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        
        for (Integer res : set) {
            return res;
        }
        return 0; */
        
        // 位运算解法
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        
        return res;
    }
}
// @lc code=end


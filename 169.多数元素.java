import java.util.*;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        TreeSet<Map.Entry<Integer, Integer>> sorted = new TreeSet<>((a, b) -> b.getValue() - a.getValue());
        sorted.addAll(entries);

        return sorted.first().getKey();
    }
}
// @lc code=end

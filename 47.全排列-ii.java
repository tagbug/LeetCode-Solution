import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> map, now;
    HashSet<List<Integer>> ans;
    Stack<Integer> stack = new Stack<>();

    private int fact(int n) {
        int ans = n;
        while (n > 2) {
            ans *= --n;
        }
        return ans;
    }

    private void search() {
        boolean next = false;
        for (Integer num : map.keySet()) {
            Integer count = now.get(num);
            if (count.intValue() == map.get(num)) {
                continue;
            }
            next = true;
            now.put(num, count + 1);
            stack.push(num);
            search();
            now.put(num, count);
            stack.pop();
        }
        if (!next) {
            ans.add(List.copyOf(stack));
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // init
        this.map = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                count = 0;
            }
            map.put(num, count + 1);
        }
        this.now = new HashMap<>(map.size());
        for (int num : map.keySet()) {
            now.put(num, 0);
        }
        ans = new HashSet<>(fact(nums.length));
        // search
        search();
        return List.copyOf(ans);
    }
}
// @lc code=end

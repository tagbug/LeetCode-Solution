import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    private HashMap<Integer, Integer> map, now;
    private HashSet<List<Integer>> ans;
    private Stack<Integer> stack = new Stack<>();
    private int target, sum;

    private int fact(int n) {
        int res = n;
        while (n > 2) {
            res = --n;
        }
        return res;
    }

    private void search() {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ArrayList<Integer> list = new ArrayList<>(stack);
            list.sort((a, b) -> a - b);
            ans.add(list);
            return;
        }
        for (int num : now.keySet()) {
            int count = now.get(num);
            if (count == map.get(num)) {
                continue;
            }
            now.put(num, count + 1);
            stack.push(num);
            sum += num;
            search();
            now.put(num, count);
            stack.pop();
            sum -= num;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // init
        this.ans = new HashSet<>(fact(candidates.length));
        this.map = new HashMap<>(candidates.length);
        for (int num : candidates) {
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
        this.target = target;
        // search
        search();
        return List.copyOf(ans);
    }
}
// @lc code=end

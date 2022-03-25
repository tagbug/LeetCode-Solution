import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
class Solution {
    private int[][] graph;
    private ArrayList<List<Integer>> ans = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    private void dfs(int i) {
        stack.push(i);
        if (i == graph.length - 1) {
            // find ans
            ans.add(List.copyOf(stack));
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            dfs(graph[i][j]);
            stack.pop();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        // DAG可以不用判断环问题
        dfs(0);
        return ans;
    }
}
// @lc code=end

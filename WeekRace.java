import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int left = 0, nextLeft = 1;
        boolean reverse = false;
        while (nextLeft != 0) {
            ArrayList<Integer> list = new ArrayList<>();
            left = nextLeft;
            nextLeft = 0;
            while (left-- != 0) {
                TreeNode node = reverse ? deque.removeLast() : deque.removeFirst();
                list.add(node.val);
                if (!reverse) {
                    // 正序
                    if (node.left != null) {
                        deque.addLast(node.left);
                        nextLeft++;
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                        nextLeft++;
                    }
                } else {
                    // 逆序
                    if (node.right != null) {
                        deque.addFirst(node.right);
                        nextLeft++;
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                        nextLeft++;
                    }
                }
            }
            reverse = !reverse;
            ans.add(list);
        }
        return ans;
    }
}
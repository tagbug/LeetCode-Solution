import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// @lc code=start
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 层级遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nextLeft = 1, left = 0;
        while (nextLeft != 0) {
            left = nextLeft;
            nextLeft = 0;
            while (left-- != 0) {
                Node node = queue.poll();
                if (left == 0) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                    nextLeft++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLeft++;
                }
            }
        }
        return root;
    }
}
// @lc code=end

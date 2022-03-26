import java.util.Stack;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// @lc code=start
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node;
            stack.push(tmp);
            node = node.next;
        }
        node = head;
        int len = stack.size();
        for (int i = 1; i < (int) Math.ceil(len / 2.0); i++) {
            ListNode pop = stack.pop();
            pop.next = node.next;
            node.next = pop;
            node = node.next.next;
        }
        if (len % 2 == 0) {
            ListNode pop = stack.pop();
            pop.next = null;
            node.next = pop;
        } else {
            node.next = null;
        }
    }
}
// @lc code=end

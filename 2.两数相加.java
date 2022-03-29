/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2;
        ListNode ans = new ListNode();
        ListNode node3 = ans;
        int overFlow = 0;
        while (node1 != null && node2 != null) {
            int res = node1.val + node2.val;
            node3.next = new ListNode((res % 10 + overFlow) % 10);
            overFlow = res / 10 + (res % 10 + overFlow) / 10;
            node2 = node2.next;
            node1 = node1.next;
            node3 = node3.next;
        }
        while (node1 != null) {
            int res = node1.val;
            node3.next = new ListNode((res % 10 + overFlow) % 10);
            overFlow = res / 10 + (res % 10 + overFlow) / 10;
            node1 = node1.next;
            node3 = node3.next;
        }
        while (node2 != null) {
            int res = node2.val;
            node3.next = new ListNode((res % 10 + overFlow) % 10);
            overFlow = res / 10 + (res % 10 + overFlow) / 10;
            node2 = node2.next;
            node3 = node3.next;
        }
        if (overFlow != 0) {
            node3.next = new ListNode(overFlow);
        }
        return ans.next;
    }
}
// @lc code=end

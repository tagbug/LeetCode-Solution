/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start

// Definition for singly-linked list.
/* class ListNode {
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
} */

/* class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }
} */
// @lc code=end

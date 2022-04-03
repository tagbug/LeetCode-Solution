/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int now = head.val;
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.val != now) {
                now = fast.val;
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        // 去掉尾部重复
        if (slow != fast) {
            slow.next = null;
        }
        return head;
    }
}
// @lc code=end

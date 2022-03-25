/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode pre = res;
        ListNode node1 = list1, node2 = list2;
        boolean flag = false;
        int next = 0;
        while (node1 != null && node2 != null) {
            if (flag == false) {
                next = Math.min(node1.val, node2.val);
            } else {
                flag = false;
            }
            if (node1.val == next) {
                node1 = node1.next;
                pre.next = new ListNode(next);
                pre = pre.next;
                flag = true;
            }
            if (node2.val == next) {
                node2 = node2.next;
                pre.next = new ListNode(next);
                pre = pre.next;
                flag = true;
            }
        }
        if (node1 != null) {
            pre.next = node1;
        } else {
            pre.next = node2;
        }
        return res.next;
    }
}
// @lc code=end
